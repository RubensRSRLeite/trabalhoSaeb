package com.example.concessionaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Alocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int area;
	
	@OneToOne
	private Automoveis automovel;
	
	@OneToOne
	private Concessionarias concessionaria;
	
	private int quantidade;
	
}
