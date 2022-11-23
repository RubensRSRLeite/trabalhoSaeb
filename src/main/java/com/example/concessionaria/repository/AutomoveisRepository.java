package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.concessionaria.model.Automoveis;

@Repository
public interface AutomoveisRepository extends PagingAndSortingRepository<Automoveis, Long> {

}
