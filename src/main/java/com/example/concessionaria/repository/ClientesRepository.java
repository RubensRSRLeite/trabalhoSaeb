package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.concessionaria.model.Clientes;

@Repository
public interface ClientesRepository extends PagingAndSortingRepository<Clientes, Long> {

}
