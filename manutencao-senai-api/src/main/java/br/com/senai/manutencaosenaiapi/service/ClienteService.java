package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.repository.ClientesRepository;

@Service
@Validated
public class ClienteService {
	
	final int IDADE_MINIMA = 12;
	
	@Autowired
	private ClientesRepository repository;

	public Cliente inserir(
			@Valid
			@NotNull(message = "O cliente nao pode ser nulo")
			Cliente novoCliente) {
		this.validarIdadeDo(novoCliente);
		Cliente clienteSalvo = repository.save(novoCliente);
		return clienteSalvo;

	}
	
	public Cliente alterar(
			@Valid 
			@NotNull(message = "O cliente nao pode ser nulo ")
			@NotNull(message = "O cliente nao pode ser nulo")
			Cliente clienteSalvo) {
		this.validarIdadeDo(clienteSalvo);
		Cliente clienteAtualizado = repository.save(clienteSalvo);
		return clienteAtualizado;
	}
	
	public List<Cliente> listarPro(
			@NotEmpty(message = "O nome é obrigatorio")
			@NotBlank(message = "O nome para busca nao deve conter espaço e branco antes da letra")		
			String nome){
		return repository.listarPor("%" +nome + "%");
				
	}
	
	public void removerPor(
			@NotNull(message = "O id para remocao nao pode ser nulo")
			@Min(value = 1, message = "O id deve ser maor que 0")
			Integer id) {
		this.repository.deleteById(id);
	}
			
	@Transient
	private void validarIdadeDo(Cliente cliente){
		Preconditions.checkArgument(cliente.getIdade() > IDADE_MINIMA,
				"O client edeve ter mais de 12 anos");
		
	}
}
