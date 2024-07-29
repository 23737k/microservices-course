package com.kentidev.order_service.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class OrderReq {
  private List<OrderLineItemReq> orderLineItems;
}
