package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
@Controller
@Validated
public class TecnicoService {

	public Tecnico inserir(@Valid @NotNull(message = "o tecnico n pode ser nulo") Tecnico novoTecnico) {

		Tecnico tecnicoSalvo = novoTecnico;
		return tecnicoSalvo;

	}

}
