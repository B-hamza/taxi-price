package com.bcg.homework.taxi.rideprice.handler;

import com.bcg.homework.taxi.rideprice.calculator.RideCalculator;
import com.bcg.homework.taxi.rideprice.domain.Ride;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class PriceHandler {
  Logger logger = LoggerFactory.getLogger(PriceHandler.class);

  public Mono<ServerResponse> ridePrice(ServerRequest request) {
    return query(request)
      .map(RideCalculator::ridePrice)
      .map(ok().contentType(APPLICATION_JSON)::bodyValue)
      .orElse(badRequest().bodyValue("distance, startTime and duration are obligatory to calculate the price"));
  }

  private Optional<Ride> query(ServerRequest request) { 
    try {
      return request.queryParam("distance")
        .flatMap(distance -> 
          request.queryParam("startTime")
            .flatMap(time -> 
              request.queryParam("duration")
                .map(duration -> new Ride(Double.parseDouble(distance), LocalDateTime.parse(time), Long.valueOf(duration)))
            )
        );
    } catch(NumberFormatException | DateTimeParseException e) {
      logger.error("price query exception", e);
      return Optional.empty();
    }
  }
  
}
