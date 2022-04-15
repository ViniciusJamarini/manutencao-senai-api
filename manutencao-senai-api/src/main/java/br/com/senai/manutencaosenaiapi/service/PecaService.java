package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Peca;

@Service
@Validated
public class PecaService {

	public Peca inserir(
			@Valid
			@NotNull(message = "A peca nao pode ser nula") Peca novaPeca) {
		Peca pecaSalva = novaPeca;
		return pecaSalva;

	}

	public Peca alterar(
		@Valid Peca pecaSalva1) {
		@NotNull(message = "A peca  nao pode ser nula")
		Peca pecaAtualizada = pecaSalva1;
		return pecaAtualizada;

	}

	public List<Peca> listarPor(
			@NotEmpty(message = "A descricao nao pode ser vazia") 
			@NotBlank(message = "A descricao nao pode conter espaços em branco antes da primeira letra") String descricao) {

		return new ArrayList<Peca>();
	}

}
