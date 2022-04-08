package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
@Validated
public class TecnicoService {

<<<<<<< HEAD
	public Tecnico inserir(@Valid
						   @NotNull(message = "O técnico não pode ser nulo")
						   Tecnico novoTecnico) {
		Preconditions.checkArgument(novoTecnico.isNovo(), "O técnico ja foi salvo");
		return novoTecnico;
	}
	
	public Tecnico alterar(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico tecnicoSalvo) {
		Preconditions.checkArgument(!tecnicoSalvo.isNovo(), "O técnico ainda não foi salvo");
		return tecnicoSalvo;
		
=======
	public Tecnico inserir(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico novoTecnico) {			
		Preconditions.checkArgument(novoTecnico.isNovo(),
				"O técnico já foi salvo");
		Tecnico tecnicoSalvo = novoTecnico;	
		return tecnicoSalvo;				
	}
	
	public Tecnico alterar(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico tecnicoSalvo) {
		Preconditions.checkArgument(!tecnicoSalvo.isNovo(), 
				"O técnico ainda não foi inserido");
		Tecnico tecnicoAtualizado = tecnicoSalvo;
		return tecnicoAtualizado;
>>>>>>> branch 'master' of https://github.com/laudelino-neto/manutencao-senai-api.git
	}
	
}
