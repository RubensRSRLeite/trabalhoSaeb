package com.example.concessionaria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.concessionaria.model.Clientes;
import com.example.concessionaria.repository.ClientesRepository;

@CrossOrigin
@RestController
@RequestMapping("api/cliente")
public class ClienteRestController {
	
	@Autowired
	ClientesRepository rep;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	ResponseEntity<Object>chamar(){
		return new ResponseEntity<Object>(rep.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object>criarCliente(@RequestBody Clientes cli){
		if (cli != null) {
			rep.save(cli);
			return new ResponseEntity<Object>("sucesso", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("cliente não pode ser nulo", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
