package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data 
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Component
public class Tecnico {
	
	private Integer id;
	
	@NotEmpty(message = "o nome nao pode ser null")
	@Size(min = 1, max = 50, message = "O nome deve conter entre 1 e 50 caracteres")
	private String nome;
	
	@NotNull (message = "A data de asmissao nao pode ser nula")
	@PastOrPresent(message = "a data de admissao nao pode ser posterior a data atual")
	private LocalDate dataDeAdmissao;
	

	
	

}
