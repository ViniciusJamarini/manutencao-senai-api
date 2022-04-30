package br.com.senai.manutencaosenaiapi;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.enums.Sexo;
import br.com.senai.manutencaosenaiapi.service.ClienteService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);

	}
	
	@Autowired
	private ClienteService clienteService;
	
	@Transactional
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				
				Cliente novoCliente = new Cliente();
				novoCliente.setNome("pUDINZINHO");
				novoCliente.setSobrenome("DaMamae");
				novoCliente.setSexo(Sexo.M);
				this.clienteService.inserir(novoCliente);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		};
	}

}
