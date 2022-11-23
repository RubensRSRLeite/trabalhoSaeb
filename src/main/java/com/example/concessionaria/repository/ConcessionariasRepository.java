package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.concessionaria.model.Concessionarias;



public interface ConcessionariasRepository extends PagingAndSortingRepository<Concessionarias, Long> {

}
