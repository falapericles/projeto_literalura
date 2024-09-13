package com.challenge.literalura;

import com.challenge.literalura.principal.Principal;
import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	LivroRepository repositorio;
	@Autowired
	AutorRepository autorRepositorio;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio, autorRepositorio);
		principal.exibeMenu();
	}
}
