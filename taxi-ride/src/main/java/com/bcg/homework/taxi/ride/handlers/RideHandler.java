package com.bcg.homework.taxi.ride.handlers;

import com.bcg.homework.taxi.ride.domain.Ride;
import com.bcg.homework.taxi.ride.services.RideService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class RideHandler {

  private final RideService service;

  public RideHandler(RideService rideService) {
    this.service = rideService;
  }
  
  public Mono<ServerResponse> listRides(ServerRequest request) {
    Flux<Ride> rides = service.rides();
    return ok().contentType(APPLICATION_JSON).body(fromPublisher(rides, Ride.class));
  }

}
