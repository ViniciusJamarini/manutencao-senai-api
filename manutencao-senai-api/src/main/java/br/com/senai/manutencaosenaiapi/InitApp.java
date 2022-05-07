package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);

	}
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private PecaService pecasService;
	
	@Autowired
	private OrdemDeServicoService ordemService;
	
	@Transactional
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {

//				var clientes=clienteService.listarPro("j");
//				Cliente clienteSelecionado = clientes.get(0);
//				
//				var tecnicos = tecnicoService.listarPor("b");
//				Tecnico tecnicoSelecionado = tecnicos.get(0);
//				
//				var pecas = pecasService.listarPor("p");
//				var pecasDeReparo = new ArrayList<Peca>();
//				pecasDeReparo.add(pecas.get(0));
//				pecasDeReparo.add(pecas.get(1));
//				
//				var novaOrdem = new OrdemDeServico();
//				novaOrdem.setCliente(clienteSelecionado);
//				novaOrdem.setTecnico(tecnicoSelecionado);
//				novaOrdem.setDataDeAbertura(LocalDate.now());
//				novaOrdem.setDescricaoDoProblema("o pc nao liga fiao");
//				novaOrdem.setPecasDeReparo(pecasDeReparo);
//				
//				this.ordemService.inserir(novaOrdem);
				
//				var clientes=clienteService.listarPro("j");
//				var ordemSalva = ordemService.buscarPor(6);
//				ordemSalva.setCliente(clientes.get(2));
//				ordemService.alterar(ordemSalva);
//						System.out.println(ordemSalva);
						
						
				var ordemSalva = ordemService.buscarPor(6);
				ordemSalva.getPecasDeReparo().add(ordemSalva.getPecasDeReparo().get(0));
				ordemSalva.setDescricaoDoReparo("poeira");
				ordemSalva.setDataDeEncerramento(LocalDate.of(2022, 05, 07));
				
				this.ordemService.fechar(ordemSalva);
				
				
//				Cliente novoCliente = new Cliente();
//				novoCliente.setNome("Kaiky");
//				novoCliente.setSobrenome("Cando");
//				novoCliente.setSexo(Sexo.M);
//				this.clienteService.inserir(novoCliente);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		};
	}

}
