package com.hzcf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient 
public class PlantformApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlantformApplication.class, args);
	}
	
}