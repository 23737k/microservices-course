package com.kentidev.inventory_service.repository;

import com.kentidev.inventory_service.model.Inventory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
  boolean existsBySkuCode(String skuCode);
  List<Inventory> findInventoriesBySkuCodeIn(List<String> skuCodes);
}
