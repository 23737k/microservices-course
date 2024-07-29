package com.kentidev.order_service.dto.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineItemRes {
  private Integer id;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}
