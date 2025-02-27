package com.embracon.teste.mapper.log;

import java.util.List;

import com.embracon.teste.dto.cep.CepDTO;
import com.embracon.teste.dto.log.LogDTO;
import com.embracon.teste.model.log.Log;

public class LogMapper {
	private LogMapper() {
		super();
	}

	public static LogDTO toDTO(Log log) {
        return new LogDTO(log.getId(), log.getCep(), log.getUf(), log.getDtHrConsulta());
    }

    public static List<LogDTO> toDTOList(List<Log> logs) {
        return logs.stream().map(LogMapper::toDTO).toList();
    }
    
	public static Log toEntity(LogDTO log) {
        return new Log(log.getCep(), log.getUf(), log.getDtHrConsulta());
    }
	
	public static LogDTO fromCepDTOtoLogDTO(CepDTO cepDTO) {
		String cepCorrigido = cepDTO.cep() != null && !cepDTO.cep().isBlank() ? cepDTO.cep().replaceAll("\\D", "") : null;
        return new LogDTO(null, cepCorrigido, cepDTO.uf(), null);
    }
}
