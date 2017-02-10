package com.nobodyiam.spring.in.action.reservation.client;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jason on 5/5/16.
 */
@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationClientApplication {
	@Bean
	CommandLineRunner runner(DiscoveryClient dc) {
		final List<ServiceInstance> list = dc.getInstances("reservation-service");
		return new CommandLineRunner (){
			@Override
			public void run(String... paramArrayOfString) throws Exception {
				for (ServiceInstance si : list) {
					System.out.println(String.format("Found %s %s:%s", si.getServiceId(), si.getHost(), si.getPort()));
				}
			}
		};
			 
	}

	/**
	 * The load balanced rest template
	 */
	@LoadBalanced
	@Bean
	RestTemplate loadBalanced() {
		return new RestTemplate();
	}

	/**
	 * The normal rest template
	 */
	@Primary
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationClientApplication.class, args);
	}
}
