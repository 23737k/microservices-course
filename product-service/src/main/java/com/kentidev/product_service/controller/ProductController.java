package com.kentidev.product_service.controller;

import com.kentidev.product_service.dto.req.ProductReq;
import com.kentidev.product_service.dto.res.ProductRes;
import com.kentidev.product_service.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProductRes> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void addProduct(@RequestBody ProductReq productReq) {
    productService.saveProduct(productReq);
  }


}
