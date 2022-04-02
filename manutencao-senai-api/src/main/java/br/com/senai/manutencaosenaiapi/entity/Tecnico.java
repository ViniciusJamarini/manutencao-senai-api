package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data 
@ToString
@EqualsAndHashCode
@Component
public class Tecnico {
	
	private Integer id;
	
	private String nome;
	
	private LocalDate dataDeAdmissao;
	

	
	

}
