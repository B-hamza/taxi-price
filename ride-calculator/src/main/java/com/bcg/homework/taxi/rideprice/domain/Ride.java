package com.bcg.homework.taxi.rideprice.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Ride {
  
  private final double distance;
  private final LocalDateTime startTime;
  private final long duration;

}

