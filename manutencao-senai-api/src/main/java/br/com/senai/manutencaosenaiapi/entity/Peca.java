package br.com.senai.manutencaosenaiapi.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Peca {
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "A descricao nao pode ser vazia")
	@NotBlank(message = "nao deve conter espaço antes da primeira palavra")
	private String descricao;
	
	
	private String especificacao;
	
	@NotNull(message = "A quantidade é obrigatoria ")
	@Min(value = 0, message = "A quantidade nao pode ser menos que 0")
	private Integer qtdeEmEstoque;
	
	
}
