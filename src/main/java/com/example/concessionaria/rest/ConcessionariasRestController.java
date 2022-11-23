package com.example.concessionaria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.concessionaria.model.Concessionarias;
import com.example.concessionaria.repository.ConcessionariasRepository;

@CrossOrigin
@RestController
@RequestMapping("api/conc")
public class ConcessionariasRestController {

	@Autowired
	ConcessionariasRepository rep;
	
	@RequestMapping(value = "", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object>chamar(){
		return new ResponseEntity<Object>(rep.findAll(), HttpStatus.OK);
	}

	ResponseEntity<Object>criarCons(@RequestBody Concessionarias cons){
		if (cons != null) {
			rep.save(cons);
			return new ResponseEntity<Object>("sucesso", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("concessionaria não pode ser nula", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
