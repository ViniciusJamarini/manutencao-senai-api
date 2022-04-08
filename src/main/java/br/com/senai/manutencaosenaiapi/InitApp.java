package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
<<<<<<< HEAD
	}

	@Autowired
	private TecnicoService service;
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			try {
				Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				
//				LocalDate dataDeAdmissao = LocalDate.of(2022, 5, 17);
//				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				
//				this.service.inserir(novoTecnico);
				
				this.service.alterar(novoTecnico);
				System.out.println("Técnico salvo com sucesso");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}
	
=======
		
	}
	
	@Autowired
	private TecnicoService service;
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				LocalDate dataDeAdmissao = LocalDate.of(2022, 4, 7);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				this.service.inserir(novoTecnico);*/
				Tecnico tecnicoSalvo = new Tecnico();
				tecnicoSalvo.setId(1);
				tecnicoSalvo.setNomeCompleto("Joanecleidson");
				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
				this.service.alterar(tecnicoSalvo);
				System.out.println("Técnico salvo com sucesso");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}

>>>>>>> branch 'master' of https://github.com/laudelino-neto/manutencao-senai-api.git
}
