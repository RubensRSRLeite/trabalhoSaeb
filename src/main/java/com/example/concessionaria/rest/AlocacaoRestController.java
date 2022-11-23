package com.example.concessionaria.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.concessionaria.model.Alocacao;
import com.example.concessionaria.repository.AlocacaoRepository;
import com.example.concessionaria.repository.AutomoveisRepository;
import com.example.concessionaria.repository.ConcessionariasRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/alocacao")
public class AlocacaoRestController {
	
	@Autowired
	AlocacaoRepository rep;
	
	@Autowired
	ConcessionariasRepository concRep;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	ResponseEntity<Object>chamar(){
		return new ResponseEntity<Object>(rep.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object>CriaAlocacao(@RequestBody Alocacao alocacao){
		if (alocacao != null) {
			rep.save(alocacao);
			return new ResponseEntity<Object>("sucesso", HttpStatus.CREATED );
		}else {
			return new ResponseEntity<Object>("Alocação não pode ser nula", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/achaauto/{id}", method = RequestMethod.GET)
	ResponseEntity<Object>concAuto(@PathVariable("id") Long id){
		
		if (id != null) {
				return new ResponseEntity<Object>(concRep.concPorAuto(id), HttpStatus.OK); 
		} else {
			return new ResponseEntity<Object>("sem id de carro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/venda/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object>venda(@PathVariable("id") Long id){
		Optional<Alocacao> qtt = rep.findById(id);
		qtt.get().setQuantidade(qtt.get().getQuantidade()-1);
		Alocacao alocacao = new Alocacao();
		alocacao.setQuantidade(qtt.get().getQuantidade());
		rep.save(alocacao);
		return new ResponseEntity<Object>("sucesso", HttpStatus.OK);
	}
	
}
