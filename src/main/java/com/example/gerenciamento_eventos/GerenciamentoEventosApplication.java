package com.example.gerenciamento_eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GerenciamentoEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoEventosApplication.class, args);
	}
}
