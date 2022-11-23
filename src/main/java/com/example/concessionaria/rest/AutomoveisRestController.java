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

import com.example.concessionaria.model.Automoveis;
import com.example.concessionaria.repository.AutomoveisRepository;
import com.example.concessionaria.repository.ConcessionariasRepository;

@CrossOrigin
@RestController
@RequestMapping("api/automovel")
public class AutomoveisRestController {

	@Autowired
	AutomoveisRepository rep;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	ResponseEntity<Object>chamar(){
		return new ResponseEntity<Object>(rep.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object>criarAutomovel(@RequestBody Automoveis auto){
		if (auto != null) {
			rep.save(auto);
			return new ResponseEntity<Object>("sucesso", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("automovel não pode ser nulo", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
}
