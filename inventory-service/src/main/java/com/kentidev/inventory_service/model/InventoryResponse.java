package com.kentidev.inventory_service.model;

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
