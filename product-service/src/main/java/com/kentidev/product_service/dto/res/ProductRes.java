package com.kentidev.product_service.dto.res;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRes {
  private String id;
  private String name;
  private String description;
  private BigDecimal price;

}
