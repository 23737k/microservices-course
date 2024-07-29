package com.kentidev.order_service.controller;

import com.kentidev.order_service.dto.request.OrderReq;
import com.kentidev.order_service.dto.response.OrderRes;
import com.kentidev.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
   private final OrderService orderService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public OrderRes createOrder(@RequestBody OrderReq orderReq) {
      return orderService.saveOrder(orderReq);
   }
}
