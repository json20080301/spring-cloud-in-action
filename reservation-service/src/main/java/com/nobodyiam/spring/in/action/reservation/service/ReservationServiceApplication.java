package com.nobodyiam.spring.in.action.reservation.service;

import com.google.common.base.Splitter;

import com.nobodyiam.spring.in.action.reservation.service.entity.Reservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jason on 5/3/16.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {
	@Bean
	CommandLineRunner runner(final ReservationRepository rr) {
		return new CommandLineRunner() {
			@Override
			public void run(String... paramArrayOfString) throws Exception {
				rr.deleteAll();
				Iterable<String>  it =	Splitter.on(",").omitEmptyStrings().trimResults().split("Tom, Jerry");
				for (String x : it) {
					rr.save(new Reservation(x));
				}
				for (Reservation  reservation : rr.findAll()) {
					System.out.println(reservation);
				} 
			}

		};
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ReservationServiceApplication.class).run(args);
	}
}
