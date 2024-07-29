package com.kentidev.order_service.service;

import com.kentidev.order_service.dto.request.OrderLineItemReq;
import com.kentidev.order_service.dto.response.OrderLineItemRes;
import com.kentidev.order_service.dto.response.OrderRes;
import com.kentidev.order_service.model.Order;
import com.kentidev.order_service.model.OrderLineItem;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
  public OrderLineItem toOrderLineItem(OrderLineItemReq orderLineItemReq){
    return OrderLineItem.builder()
        .price(orderLineItemReq.getPrice())
        .quantity(orderLineItemReq.getQuantity())
        .skuCode(orderLineItemReq.getSkuCode())
        .build();
  }
  public OrderRes toOrderRes(Order order){
    return OrderRes.builder()
        .id(order.getId())
        .orderNumber(order.getOrderNumber())
        .orderLineItems(order.getOrderLineItems().stream().map(this::toOrderLineItemRes).toList())
        .build();
  }

  public OrderLineItemRes toOrderLineItemRes(OrderLineItem orderLineItem){
    return OrderLineItemRes.builder()
        .id(orderLineItem.getId())
        .price(orderLineItem.getPrice())
        .quantity(orderLineItem.getQuantity())
        .skuCode(orderLineItem.getSkuCode())
        .build();
  }

}
