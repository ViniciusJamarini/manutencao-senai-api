package br.com.senai.manutencaosenaiapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
@Controller
public class TecnicoService {

	public Tecnico inserir(Tecnico novoTecnico) {

		Preconditions.checkNotNull(novoTecnico, "O tecnico nao deve ser nulo");
		Preconditions.checkArgument(novoTecnico.getNome() != null && !novoTecnico.getNome().isEmpty(),
				"O nome é obrigatorio");
		Preconditions.checkArgument(novoTecnico.getDataDeAdmissao() != null, "A data de admissaé obrigatoria");

		LocalDate dataAtual = LocalDate.now();
		LocalDate dataDeAdmissao = novoTecnico.getDataDeAdmissao();

		Preconditions.checkArgument(
				novoTecnico.getDataDeAdmissao().isBefore(dataAtual) || dataDeAdmissao.equals(dataDeAdmissao),
				"A data de admissão deve ser igual ou anterior a data atual");

		Tecnico tecnicoSalvo = novoTecnico;
		return tecnicoSalvo;

	}

}
