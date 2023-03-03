package com.epulCinema.CinemaEpulSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class CinemaEpulSpringApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CinemaEpulSpringApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CinemaEpulSpringApplication.class, args);
	}
}


