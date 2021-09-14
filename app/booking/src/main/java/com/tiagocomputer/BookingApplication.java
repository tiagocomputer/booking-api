package com.tiagocomputer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public OpenAPI openApiConfig(){
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo() {
		Info info = new Info();
		info
				.title("Booking API")
				.description("Booking system")
				.version("v1.0.0");
		return info;
	}
}
