package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Cliente;

@Service
@Validated
public class ClienteService {
	
	final int IDADE_MINIMA = 12;

	public Cliente inserir(@Valid Cliente novoCliente) {
		Preconditions.checkArgument(novoCliente.getIdade() > IDADE_MINIMA,
				"O client edeve ter mais de 12 anos");
		Cliente clienteSalvo = novoCliente;
		return clienteSalvo;

	}

}
