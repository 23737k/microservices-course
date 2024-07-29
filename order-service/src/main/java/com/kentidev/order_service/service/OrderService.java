package com.kentidev.order_service.service;

import com.kentidev.order_service.dto.request.OrderReq;
import com.kentidev.order_service.dto.response.OrderRes;
import com.kentidev.order_service.model.Order;
import com.kentidev.order_service.repository.OrderRepo;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepo orderRepo;
  private final OrderMapper orderMapper;

  public OrderRes saveOrder(OrderReq orderReq){
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setOrderLineItems(orderReq.getOrderLineItems().stream().map(orderMapper::toOrderLineItem).toList());
    return orderMapper.toOrderRes(orderRepo.save(order));
  }




}
