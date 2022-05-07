package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity(name = "OrdemDeServico")
@Table(name = "ordens_servicos")
public class OrdemDeServico {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@NotNull(message = "O cliente da ordem nao pode ser nulo")
	private Cliente cliente;

	@NotNull(message = "O tecnico da ordem nao pode ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;

	@NotNull(message = "A data de abertura e obrigatoria")
	@PastOrPresent(message = "A data de abertura nao pode ser posterior a data atual")
	@Column(name = "dt_abertura")
	private LocalDate dataDeAbertura;

	@PastOrPresent(message = "A data de encerramento nao pode ser posterior a data atual")
	@Column(name = "dt_encerramento")
	private LocalDate dataDeEncerramento;

	@NotEmpty(message = "A descricao do problema é obrigatoria")
	@NotBlank(message = "A descricao do problema nao foi informada")
	@Column(name = "desc_problema")
	private String descricaoDoProblema;

	@Column(name = "desc_reparo")
	private String descricaoDoReparo;

	@Column()
	@ManyToMany
	@JoinTable(name = "pecas_reparos", joinColumns = @JoinColumn(name = "id_ordem"), inverseJoinColumns = @JoinColumn(name = "id_peca"))
	@NotEmpty(message = "Deve haver ao menos uma peça de reparo")
	private List<Peca> pecasDeReparo;

}
