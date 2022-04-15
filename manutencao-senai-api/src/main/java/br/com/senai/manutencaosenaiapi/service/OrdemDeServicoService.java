package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;

@Service
@Validated
public class OrdemDeServicoService {

	public OrdemDeServico inserir(@Valid OrdemDeServico novaOrdem) {
		this.validar(novaOrdem);
		OrdemDeServico ordemSalva = novaOrdem;
		return ordemSalva;
	}

	private void validar(OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDescricaoDoReparo() == null,
				"A descricao do reparo nao deve ser informada na abertura");
		Preconditions.checkArgument(ordem.getDataDeEncerramento() == null,
				" Data de encerramento nao deve ser informada na abertura");
	}

	public OrdemDeServico alterar(@Valid OrdemDeServico ordemSalva) {
		this.validar(ordemSalva);
		OrdemDeServico ordemAtualizada = ordemSalva;
		return ordemAtualizada;
	}

	public OrdemDeServico fechar(@Valid OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDataDeEncerramento() != null, "A data de encerramento é obrigatoria");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(ordem.getDescricaoDoReparo()), "A descricao do reparo");
		boolean isPosterios = ordem.getDataDeEncerramento().isAfter(ordem.getDataDeAbertura());
		Preconditions.checkArgument(isPosterios, "A data de encerramento deve ser porterior a data de abertura");
		OrdemDeServico ordemAtualizada = ordem;
		return ordemAtualizada;
	}

}
