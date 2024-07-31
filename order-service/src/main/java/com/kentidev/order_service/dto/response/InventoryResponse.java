package com.kentidev.order_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InventoryResponse {
  private String skuCode;
  private boolean isInStock;
}
