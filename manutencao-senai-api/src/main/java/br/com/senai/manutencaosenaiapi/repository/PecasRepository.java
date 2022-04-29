package br.com.senai.manutencaosenaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.manutencaosenaiapi.entity.Peca;


public interface PecasRepository extends JpaRepository<Peca, Integer> {
	

}
