package com.kentidev.inventory_service.controller;

import com.kentidev.inventory_service.model.InventoryResponse;
import com.kentidev.inventory_service.service.InventoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
  private final InventoryService inventoryService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<InventoryResponse> inInStock(@RequestParam List<String> skuCodes){
    return inventoryService.isInStock(skuCodes);
  }
}
