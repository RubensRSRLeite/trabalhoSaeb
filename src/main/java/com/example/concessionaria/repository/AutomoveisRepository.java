package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.concessionaria.model.Automoveis;


public interface AutomoveisRepository extends PagingAndSortingRepository<Automoveis, Long> {

}
