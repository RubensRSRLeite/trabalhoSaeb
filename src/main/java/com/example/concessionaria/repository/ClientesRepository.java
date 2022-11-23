package com.example.concessionaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.concessionaria.model.Clientes;

public interface ClientesRepository extends PagingAndSortingRepository<Clientes, Long> {

}
