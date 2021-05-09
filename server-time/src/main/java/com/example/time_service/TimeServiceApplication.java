package com.example.time_service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class TimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeServiceApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				// .components(new Components().addSecuritySchemes("basicScheme",new
				// SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info() //
						.title("TimeService") //
						.version("1.0.0") //
						.license(new License().name("Apache 2.0").url("http://springdoc.org")) //
						.contact(new Contact().name("Max Muster").email("max@muster.de"))
				);
	}

}
