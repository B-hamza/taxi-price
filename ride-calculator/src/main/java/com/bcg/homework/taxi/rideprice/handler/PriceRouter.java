package com.bcg.homework.taxi.rideprice.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class PriceRouter {
  
  @Bean
  public RouterFunction<ServerResponse> price(PriceHandler handler) {
    return RouterFunctions.route()
      .GET("/price", handler::ridePrice)
      .build();
  }
  
}
