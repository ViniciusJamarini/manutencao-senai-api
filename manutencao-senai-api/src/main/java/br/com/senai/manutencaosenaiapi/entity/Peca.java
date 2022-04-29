package br.com.senai.manutencaosenaiapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name="Peca")
@Table(name="pecas")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Peca {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "descricao")
	@NotEmpty(message = "A descricao nao pode ser vazia")
	@NotBlank(message = "nao deve conter espaço antes da primeira palavra")
	@Size(max = 150, message = "A descricao so pode ter 150 caracteres")
	private String descricao;
	
	@Column(name= "especificacoes")
	@Size(max = 400, message = "A especificacao so pode ter 400 caracteres")
	private String especificacao;
	
	@Column(name= "qtde_estoque")
	@NotNull(message = "A quantidade é obrigatoria ")
	@Min(value = 0, message = "A quantidade nao pode ser menos que 0")
	private Integer qtdeEmEstoque;
	
	
}
