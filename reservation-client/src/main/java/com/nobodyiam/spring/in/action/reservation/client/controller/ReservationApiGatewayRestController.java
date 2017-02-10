package com.nobodyiam.spring.in.action.reservation.client.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobodyiam.spring.in.action.reservation.client.dto.Reservation;

/**
 * Created by Jason on 5/10/16.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationApiGatewayRestController {
  @Autowired
  @LoadBalanced
  private RestTemplate rt;

  private Collection<String> getReservationNamesFallback() {
    return Collections.emptyList();
  }
//http://localhost:9999/reservations/names
  @RequestMapping("/names")
  @HystrixCommand(fallbackMethod = "getReservationNamesFallback")
  public Collection<String> getReservationNames() {

    ParameterizedTypeReference<Resources<Reservation>> parameterizedTypeReference =
            new ParameterizedTypeReference<Resources<Reservation>>() {
            };

    ResponseEntity<Resources<Reservation>> exchange = rt.exchange(
            "http://reservation-service/reservations",
            HttpMethod.GET, null, parameterizedTypeReference);
    
    Collection<Reservation> reservations =  exchange.getBody().getContent();
    List<String> strs = new ArrayList<String>();
    for (Reservation reservation : reservations) {
    	strs.add(reservation.getReservationName());
	}
    return strs ;
//    return FluentIterable.from(exchange.getBody().getContent())
//            .transform(Reservation::getReservationName).toList();
  }
}
