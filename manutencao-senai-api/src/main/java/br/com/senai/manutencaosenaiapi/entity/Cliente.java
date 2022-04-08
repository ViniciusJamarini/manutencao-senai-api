package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import br.com.senai.manutencaosenaiapi.enums.Sexo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "Onome nao pode ser nulo" )
	private String nome;
	
	@NotEmpty(message = "O sobrenome nao pode ser nulo")
	private String sobrenome;
	
	@NotEmpty(message = "O cpf nao pode ser nulo")
	@Pattern(regexp = "NNN.NNN.NNN-NN")
	private String cpf;
	
	@NotNull(message = "O sexo é obrigario")
	private Sexo sexo;
	
	@NotEmpty(message = "O endereço noa pode ser nulo")
	private String endereco;
	
	@NotNull(message = "A data de nascimento noa pode er nula")
	@Past(message = "A data de nascimento deve ser anterior a data atual")
	private LocalDate dataDeNascimento;
	
	public Integer getIdade() {
		int idade = LocalDate.now().getYear() - getDataDeNascimento().getYear();
		return idade;
		
	}
	
		
	
}
