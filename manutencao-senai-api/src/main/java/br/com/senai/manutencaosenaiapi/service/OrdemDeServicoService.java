package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.OrdensDeServicoRepository;

@Service
@Validated
public class OrdemDeServicoService {

	@Autowired
	private OrdensDeServicoRepository repository;

	public OrdemDeServico inserir(@Valid @NotNull(message = "A nova ordem é obrigadotira") OrdemDeServico novaOrdem) {
		this.validar(novaOrdem);
		OrdemDeServico ordemSalva = repository.save(novaOrdem);
		return ordemSalva;
	}

	public OrdemDeServico alterar(@Valid @NotNull(message = "a ordem salva é obrigatoria") OrdemDeServico ordemSalva) {
		this.validar(ordemSalva);
		OrdemDeServico ordemAtualizada = repository.save(ordemSalva);
		return ordemAtualizada;
	}

	public OrdemDeServico fechar(@Valid @NotNull(message = "A ordem é obrigatoria") OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDataDeEncerramento() != null, "A data de encerramento é obrigatoria");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(ordem.getDescricaoDoReparo()), "A descricao do reparo");
		boolean isPosterios = ordem.getDataDeEncerramento().isAfter(ordem.getDataDeAbertura());
		Preconditions.checkArgument(isPosterios, "A data de encerramento deve ser porterior a data de abertura");
		
		for(Peca peca : ordem.getPecasDeReparo()) {
			int qtdeDeOcorrencias = 0;
			for (Peca outraPeca : ordem.getPecasDeReparo()) {
				if (peca.equals(outraPeca)) {
					qtdeDeOcorrencias++;
				}
			}
			Preconditions.checkArgument(qtdeDeOcorrencias==1, "A peca: " + peca.getDescricao() + " ja foi adicionada");
		}
		
		OrdemDeServico ordemAtualizada = repository.save(ordem);

		return ordemAtualizada;
	}

	private void validar(OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDescricaoDoReparo() == null,
				"A descricao do reparo nao deve ser informada na abertura");
		Preconditions.checkArgument(ordem.getDataDeEncerramento() == null,
				" Data de encerramento nao deve ser informada na abertura");
		Preconditions.checkArgument(ordem.getPecasDeReparo().isEmpty(),
				"Nao devem ser informadas pecas na abertura da ordem");

	}

	public List<OrdemDeServico> listarPor(
			@NotNull(message = "O id do cliente é obrigatorio") @Min(value = 0, message = "o id deve ser maior que 0") Integer idDoCliente) {

		return new ArrayList<OrdemDeServico>();
	}

	public OrdemDeServico buscarPor(
			@NotNull(message = "o id da ordem é obrigatorio") @Min(value = 1, message = "O id da ordem deve ser maio que 1") Integer id) {
		return repository.buscarPor(id);
	}

	public void removerPor(
			@NotNull(message = "O id da ordem é obrigatorio") @Min(value = 1, message = "O id deve ser maior que 0") Integer idDoCliente) {

	}
}
