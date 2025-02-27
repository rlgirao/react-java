package com.embracon.teste.controller.log;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embracon.teste.dto.log.LogDTO;
import com.embracon.teste.dto.log.RetornoConsultaLogDTO;
import com.embracon.teste.service.log.LogService;

@RestController
@RequestMapping("/log")
public class LogController {

	private LogService logService;

	public LogController(LogService logService) {
		super();
		this.logService = logService;
	}
    
    @GetMapping("/buscar-todos")
    public ResponseEntity<List<LogDTO>> buscarTodos() {
        return ResponseEntity.ok(logService.buscarTodos());
    }
    
    @GetMapping("/buscar-por-uf")
    public ResponseEntity<List<RetornoConsultaLogDTO>> buscarPorUf(@RequestParam String uf) {
        return ResponseEntity.ok(logService.buscarPorUf(uf));
    }
	
}
