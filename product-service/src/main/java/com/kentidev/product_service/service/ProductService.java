package com.kentidev.product_service.service;

import com.kentidev.product_service.dto.req.ProductReq;
import com.kentidev.product_service.dto.res.ProductRes;
import com.kentidev.product_service.repository.ProductRepo;
import com.kentidev.product_service.service.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepo productRepo;
  private final ProductMapper productMapper;

  public List<ProductRes> getAllProducts(){
    return productRepo.findAll().stream().map(productMapper::toProductRes).toList();
  }

  public ProductRes saveProduct(ProductReq productReq){
    return productMapper.toProductRes(productRepo.save(productMapper.toProduct(productReq)));
  }



}
