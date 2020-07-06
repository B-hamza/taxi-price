package com.bcg.homework.taxi.ride.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class RideRouter {
  
  @Bean
  public RouterFunction<ServerResponse> rides(RideHandler handler) {
    return RouterFunctions.route()
      .GET("/rides", handler::listRides)
      .build();
  }
   
}
