package com.kentidev.order_service.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderLineItemReq {
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}
