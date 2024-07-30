package com.kentidev.inventory_service.controller;

import com.kentidev.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
  private final InventoryService inventoryService;

  @GetMapping("/{skuCode}")
  @ResponseStatus(HttpStatus.OK)
  public boolean inInStock(@PathVariable String skuCode){
    return inventoryService.isInStock(skuCode);
  }
}
