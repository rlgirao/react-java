package com.embracon.teste.controller.cep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embracon.teste.dto.cep.CepDTO;
import com.embracon.teste.service.cep.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {

	private CepService cepService;

	public CepController(CepService cepService) {
		super();
		this.cepService = cepService;
	}

    @GetMapping("/consulta-cep/{cep}")
    public ResponseEntity<CepDTO> consultarCep(@PathVariable String cep) {        
    	return ResponseEntity.ok(cepService.consultarCep(cep));
    }
}
