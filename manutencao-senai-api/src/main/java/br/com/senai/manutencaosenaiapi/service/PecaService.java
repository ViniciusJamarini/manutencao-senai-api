package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;

@Service
@Validated
public class PecaService {

	private PecasRepository repository;

	public Peca inserir(
			@Valid
			@NotNull(message = "A peca nao pode ser nula") Peca novaPeca) {
		Peca pecaSalva = repository.save(novaPeca);
		return pecaSalva;

	}

	public Peca alterar(@Valid Peca pecaSalva) {
		@NotNull(message = "A peca  nao pode ser nula")
		Peca pecaAtualizada = repository.save(pecaSalva);
		return pecaAtualizada;

	}

	public void removerPor(
			@NotNull(message = "id nao podeser nulo")
			@Min(value = 1, message = "o id da peca deve ser maior que 0") 
			Integer id) {

		this.repository.deleteById(id);

	}

	public List<Peca> listarPor(
			@NotEmpty(message = "A descricao nao pode ser vazia")
			@NotBlank(message = "A descricao nao pode conter espaços em branco antes da primeira letra")
			String descricao) {

		return repository.listarPor("%" + descricao + "%");
	}

}
