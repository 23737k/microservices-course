package com.kentidev.inventory_service.service;

import com.kentidev.inventory_service.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private final InventoryRepo inventoryRepo;

  public boolean isInStock(String skuCode){
    return inventoryRepo.existsBySkuCode(skuCode);
  }
}
