package com.kentidev.order_service.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRes {
  private Integer id;
  private String orderNumber;
  private List<OrderLineItemRes> orderLineItems;
}
