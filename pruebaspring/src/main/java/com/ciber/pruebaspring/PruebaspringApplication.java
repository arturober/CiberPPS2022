package com.ciber.pruebaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaspringApplication.class, args);
	}

	@GetMapping("/hola")
	public String hola() {
		return "Hola mundo";
	}

}
