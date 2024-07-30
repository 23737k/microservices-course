package com.kentidev.inventory_service.config;

import com.kentidev.inventory_service.model.Inventory;
import com.kentidev.inventory_service.repository.InventoryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
  @Bean
  CommandLineRunner loadData(InventoryRepo inventoryRepo, EntityManager em) {
    return args -> {
      Query query = em.createQuery("SELECT COUNT(*) FROM Inventory");
      Long count = (Long) query.getSingleResult();
      if(count < 1 ) {
        Inventory inventory1 = Inventory.builder()
            .skuCode("i1300sf")
            .quantity(15)
            .build();
        Inventory inventory2 = Inventory.builder()
            .skuCode("chu-304")
            .quantity(5)
            .build();

        inventoryRepo.save(inventory1);
        inventoryRepo.save(inventory2);
      }
    };
  }
}
