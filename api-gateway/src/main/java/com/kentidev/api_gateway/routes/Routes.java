package com.kentidev.api_gateway.routes;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

  @Bean
  RouterFunction<ServerResponse> productServiceRoute() {
    return route()
        .path("api/products" , builder -> builder
          .GET(http())
          .POST(http())
        )
        .filter(lb("product-service"))
        .build();

  }

  @Bean
  RouterFunction<ServerResponse> orderServiceRoute() {
    return route()
        .POST("/api/orders",http())
        .filter(lb("order-service"))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> inventoryServiceRoute() {
    return route()
        .path("api/inventory" , builder -> builder
            .GET(http())
        )
        .filter(lb("inventory-service"))
        .build();
  }



  /* .filter(lb("product-service")):
  * Aplica un filtro a la ruta. Este filtro utiliza un balanceador de carga (lb) para redirigir la solicitud al servicio product-service.
   Este filtro lb resuelve el nombre del servicio registrado y distribuye la carga entre las instancias disponibles.
  * */

  @Bean
  RouterFunction<ServerResponse> inventoryServiceSwagger() {
    return route()
        .path("/aggregate/inventory-service/v3/api-docs" , builder -> builder
            .GET(http())
        )
        .filter(setPath("/api-docs"))
        .filter(lb("inventory-service"))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> orderServiceSwagger() {
    return route()
        .path("/aggregate/order-service/v3/api-docs" , builder -> builder
            .GET(http())
        )
        .filter(setPath("/api-docs"))
        .filter(lb("order-service"))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> productServiceSwagger() {
    return route()
        .path("/aggregate/product-service/v3/api-docs" , builder -> builder
            .GET(http())
        )
        .filter(setPath("/api-docs"))
        .filter(lb("product-service"))
        .build();
  }


}
