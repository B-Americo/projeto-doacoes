package com.americo.org.doacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;

@SpringBootApplication
public class DoacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoacoesApplication.class, args);
		Logger.info("Sistema de gerenciamento de doações iniciado com sucesso!");
	}


}
