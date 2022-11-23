package com.example.concessionaria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Concessionarias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String concessionaria; 
	
	@OneToMany
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Clientes> clientes;
	
	
}
