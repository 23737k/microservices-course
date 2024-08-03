package com.kentidev.order_service.service;

import com.kentidev.order_service.dto.request.OrderLineItemReq;
import com.kentidev.order_service.dto.request.OrderReq;
import com.kentidev.order_service.dto.response.InventoryResponse;
import com.kentidev.order_service.dto.response.OrderRes;
import com.kentidev.order_service.model.Order;
import com.kentidev.order_service.repository.OrderRepo;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepo orderRepo;
  private final OrderMapper orderMapper;
  private final WebClient.Builder webClientBuilder;

  public OrderRes saveOrder(OrderReq orderReq){
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setOrderLineItems(orderReq.getOrderLineItems().stream().map(orderMapper::toOrderLineItem).toList());

    //Call Inventory Service and save order if its products are in stock
    List<String> skuCodes = orderReq.getOrderLineItems().stream().map(OrderLineItemReq::getSkuCode).toList();

    InventoryResponse[] result =  webClientBuilder.build().get()
        .uri("http://inventory-service/api/inventory",
            uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();
    boolean allProductsInStock = Arrays.stream(result).allMatch(InventoryResponse::isInStock);

    if(allProductsInStock){
      return orderMapper.toOrderRes(orderRepo.save(order));
    }
    else {
      throw new IllegalArgumentException("Product is not in stock");
    }

  }




}
