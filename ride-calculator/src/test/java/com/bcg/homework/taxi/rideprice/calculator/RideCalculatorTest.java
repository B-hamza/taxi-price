package com.bcg.homework.taxi.rideprice.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcg.homework.taxi.rideprice.domain.Ride;

import org.junit.jupiter.api.Test;

public class RideCalculatorTest {

  @Test
  public void shouldCalculatePrice() {
    var ride1 = new Ride(2, LocalDateTime.of(2020, 6, 19, 13, 01, 17), 9000l);
    var ride2 = new Ride(1, LocalDateTime.of(2020, 6, 19, 12, 01, 17), 6000l);
    var ride3 = new Ride(5, LocalDateTime.of(2020, 6, 19, 14, 01, 17), 7000l);
    var ride4 = new Ride(5, LocalDateTime.of(2020, 6, 19, 13, 11, 17), 4000l);

    assertEquals(BigDecimal.valueOf(6.0), RideCalculator.ridePrice(ride1));
    assertEquals(BigDecimal.valueOf(3.5), RideCalculator.ridePrice(ride2));
    assertEquals(BigDecimal.valueOf(13.5), RideCalculator.ridePrice(ride3));
    assertEquals(BigDecimal.valueOf(13.5), RideCalculator.ridePrice(ride4));
  }

  @Test
  public void shouldCalculareDifferentPriceinBussyPeriod() {
    var ride_busy_period = new Ride(2, LocalDateTime.of(2020, 6, 19, 17, 30, 17), 8000l);
    assertEquals(BigDecimal.valueOf(7.0), RideCalculator.ridePrice(ride_busy_period));
  }
  

  @Test
  public void shouldCalculareDifferentPriceinNightPeriod() {
    var ride_night_period = new Ride(2, LocalDateTime.of(2020, 6, 19, 21, 30, 17), 9000l);
    assertEquals(BigDecimal.valueOf(6.5), RideCalculator.ridePrice(ride_night_period));
  }

  @Test
  public void shouldCalculareDifferentPriceinNightAndBussyPeriod() {
    var ride_night_period = new Ride(2, LocalDateTime.of(2020, 6, 19, 17, 30, 17), 9000l);
    assertEquals(BigDecimal.valueOf(7.5), RideCalculator.ridePrice(ride_night_period));
  }
  

}
