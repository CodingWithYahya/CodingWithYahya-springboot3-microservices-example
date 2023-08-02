package com.stagedemo.serviceeducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEducationApplication.class, args);
	}

}
