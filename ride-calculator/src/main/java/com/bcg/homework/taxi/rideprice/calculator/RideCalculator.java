package com.bcg.homework.taxi.rideprice.calculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcg.homework.taxi.rideprice.domain.Ride;

public class RideCalculator {

  private static BigDecimal INITIAL_CHARGE = BigDecimal.valueOf(1);
  private static BigDecimal NIGHT_CHARGE = BigDecimal.valueOf(0.5);
  private static BigDecimal BUSY_PERIOD_CHARGE = BigDecimal.valueOf(1);
  private static BigDecimal CHARGE_RATE = BigDecimal.valueOf(1/5d);
  private static BigDecimal CHARGE_PRICE = BigDecimal.valueOf(0.5);

  private static int START_BUSY_PERIOD = 16;
  private static int END_BUSY_PERIOD = 19;

  private static int START_NIGHT_PERIOD = 20;
  private static int END_NIGHT_PERIOD = 6 + 24; // a day after
  
  public static BigDecimal ridePrice(Ride ride) {
    var distance = BigDecimal.valueOf(ride.getDistance());

    var ridePrice = INITIAL_CHARGE.add(distance.divide(CHARGE_RATE).multiply(CHARGE_PRICE));

    var startRide = ride.getStartTime();
    var endRide = ride.getStartTime().plusSeconds(ride.getDuration());
    if(betweenPeriodOfHours(startRide, START_BUSY_PERIOD, END_BUSY_PERIOD) 
        || betweenPeriodOfHours(endRide, START_BUSY_PERIOD, END_BUSY_PERIOD)) {
      ridePrice = ridePrice.add(BUSY_PERIOD_CHARGE); 
    }

    if(betweenPeriodOfHours(startRide, START_NIGHT_PERIOD, END_NIGHT_PERIOD) 
        || betweenPeriodOfHours(endRide, START_NIGHT_PERIOD, END_NIGHT_PERIOD)) {
      ridePrice = ridePrice.add(NIGHT_CHARGE);
    }

    return ridePrice;
  }

  private static boolean betweenPeriodOfHours(LocalDateTime time, int startingPeriodHour, int endingPeriodHour) {
    return time.getHour() >= startingPeriodHour && time.getHour() <= endingPeriodHour;
  }
  
}
