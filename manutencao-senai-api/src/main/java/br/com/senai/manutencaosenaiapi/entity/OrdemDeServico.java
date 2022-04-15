package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class OrdemDeServico {

	private Integer id;
	
	@NotNull(message = "O cliente da ordem nao pode ser nulo")
	private Cliente cliente;
	
	@NotNull(message = "O tecnico da ordem nao pode ser nulo")
	private Tecnico tecnico;
	
	@NotNull(message = "A data de abertura ~e obrigatoria")
	@PastOrPresent(message = "A data de abertura nao pode ser posterior a data atual")
	private LocalDate dataDeAbertura;
	
	@PastOrPresent(message = "A data de encerramento nao pode ser posterior a data atual")
	private LocalDate dataDeEncerramento;
	
	@NotEmpty(message = "A descricao do problema é obrigatoria")
	@NotBlank(message = "A descricao do problema nao foi informada")
	private String descricaoDoProblema;
	
	
	private String descricaoDoReparo;
	
	@NotEmpty(message = "Deve haver ao menos uma peça de reparo")
	private List<Peca> pecasDeReparo;
	
}
