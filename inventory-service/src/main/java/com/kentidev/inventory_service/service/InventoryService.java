package com.kentidev.inventory_service.service;

import com.kentidev.inventory_service.model.InventoryResponse;
import com.kentidev.inventory_service.repository.InventoryRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private final InventoryRepo inventoryRepo;

  public List<InventoryResponse> isInStock(List<String> skuCodes){
    return inventoryRepo.findInventoriesBySkuCodeIn(skuCodes)
        .stream()
        .map( i-> InventoryResponse.builder()
            .skuCode(i.getSkuCode())
            .isInStock(i.getQuantity() > 0)
            .build())
        .toList();
  }
}
