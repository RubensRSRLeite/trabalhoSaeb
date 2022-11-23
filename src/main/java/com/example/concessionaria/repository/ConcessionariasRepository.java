package com.example.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.concessionaria.model.Concessionarias;

@Repository
public interface ConcessionariasRepository extends PagingAndSortingRepository<Concessionarias, Long> {

	@Query("SELECT c FROM Concessionarias c INNER JOIN Alocacao a ON c.id = a.concessionaria.id INNER JOIN Automoveis au ON a.automovel.id = au.id where au.id = :id")
	public List<Concessionarias> concPorAuto(@Param("id") Long id);
	
}
