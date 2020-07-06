package com.bcg.homework.taxi.ride.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.bcg.homework.taxi.ride.domain.Ride;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class RideService {

  public Flux<Ride> rides() {
    var rides = Arrays.asList(
      new Ride(1l, 2, LocalDateTime.of(2020, 6, 19, 13, 01, 17), 9000l),
      new Ride(2l, 1, LocalDateTime.of(2020, 6, 19, 12, 01, 17), 6000l),
      new Ride(3l, 5, LocalDateTime.of(2020, 6, 19, 14, 01, 17), 7000l),
      new Ride(4l, 5, LocalDateTime.of(2020, 6, 19, 13, 11, 17), 4000l)
    );
    return Flux.fromIterable(rides);
  }
  
}
