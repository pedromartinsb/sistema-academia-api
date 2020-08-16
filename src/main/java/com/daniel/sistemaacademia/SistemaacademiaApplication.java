package com.daniel.sistemaacademia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SistemaacademiaApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaacademiaApplication.class, args);
	}

}
