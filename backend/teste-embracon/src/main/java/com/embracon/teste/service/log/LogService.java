package com.embracon.teste.service.log;

import java.util.List;

import com.embracon.teste.dto.log.LogDTO;
import com.embracon.teste.dto.log.RetornoConsultaLogDTO;

public interface LogService {
	List<LogDTO> buscarTodos();
	
	LogDTO salvar(LogDTO log);

	List<RetornoConsultaLogDTO> buscarPorUf(String uf);
}
