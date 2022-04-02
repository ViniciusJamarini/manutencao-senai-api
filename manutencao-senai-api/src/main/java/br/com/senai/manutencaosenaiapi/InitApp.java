package br.com.senai.manutencaosenaiapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Autowired
	private Tecnico tecnico;
	
	@Autowired
	private Tecnico outroTecnico;
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			System.out.println("Deu certo");
			tecnico.getNome();
			tecnico.setId(1);
			
			outroTecnico.setId(1);
			System.out.println(tecnico);
			System.out.println(outroTecnico);
			if(tecnico.equals(outroTecnico)) {
				System.out.println("Sao os mesmos");
			}
			
		};
	}

}
