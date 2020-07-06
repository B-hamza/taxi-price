package com.bcg.homework.taxi.router;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class ApplicationRouter {
  
  @Bean
  public RouterFunction<ServerResponse> staticResourceRouter() {
    return RouterFunctions.resources("/**", new ClassPathResource("public/"));
  }

}
