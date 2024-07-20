package com.kentidev.product_service.service.mapper;

import com.kentidev.product_service.dto.req.ProductReq;
import com.kentidev.product_service.dto.res.ProductRes;
import com.kentidev.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductRes toProductRes(Product product) {
    return ProductRes.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
  }

  public Product toProduct(ProductReq productReq) {
    return Product.builder()
        .name(productReq.getName())
        .description(productReq.getDescription())
        .price(productReq.getPrice())
        .build();
  }
}
