package com.embracon.teste.service.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.embracon.teste.dto.log.LogDTO;
import com.embracon.teste.dto.log.RetornoConsultaLogDTO;
import com.embracon.teste.mapper.log.LogMapper;
import com.embracon.teste.repository.log.LogRepository;
import com.embracon.teste.utils.cep.CepUtil;
import com.embracon.teste.utils.uf.UfUtil;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	private final LogRepository logRepository;
	
	public LogServiceImpl(LogRepository logRepository) {
		super();
		this.logRepository = logRepository;
	}

	@Override
	public List<LogDTO> buscarTodos() {
		return LogMapper.toDTOList(logRepository.findAll(Sort.by(Sort.Direction.DESC, "dtHrConsulta")));
	}

	@Override
	public LogDTO salvar(LogDTO log) {
		validarCamposInsercao(log);
		return LogMapper.toDTO(logRepository.save(LogMapper.toEntity(log)));
	}
	
	private void validarCamposInsercao(LogDTO log) {
		Objects.requireNonNull(log, "Dados de Log não informados.");
		CepUtil.validarCep(log.getCep());
		UfUtil.validarUf(log.getUf());
		log.setDtHrConsulta(LocalDateTime.now());
	}

	@Override
	public List<RetornoConsultaLogDTO> buscarPorUf(String uf) {
		return logRepository.buscarPorUf(uf).stream()
				.map(log -> new RetornoConsultaLogDTO(log.getUf(),
						log.getDtHrConsulta() != null ? log.getDtHrConsulta().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
								: null))
				.toList();
	}
	
}
