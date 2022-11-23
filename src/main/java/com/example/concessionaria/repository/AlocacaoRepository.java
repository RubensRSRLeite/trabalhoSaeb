package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.concessionaria.model.Alocacao;

@Repository
public interface AlocacaoRepository extends PagingAndSortingRepository<Alocacao, Long>{

}
