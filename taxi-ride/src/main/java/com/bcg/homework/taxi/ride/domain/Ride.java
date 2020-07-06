package com.bcg.homework.taxi.ride.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Ride {
  
  private final long id;
  private final double distance;
  private final LocalDateTime startTime;
  private final long duration;

}
