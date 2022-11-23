package com.example.concessionaria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.concessionaria.model.Alocacao;

@Repository
public interface AlocacaoRepository extends PagingAndSortingRepository<Alocacao, Long>{

	@Query("SELECT a FROM Alocacao a where a.automovel.id = :id")
	public Optional<Alocacao>findByAutoId(@Param("id") Long id);
	
}
