package com.embracon.teste.dto.log;

import java.time.LocalDateTime;

public class LogDTO {
	private Long id;
	private String cep;
	private String uf;
	private LocalDateTime dtHrConsulta;
		
	public LogDTO(Long id, String cep, String uf, LocalDateTime dtHrConsulta) {
		super();
		this.id = id;
		this.cep = cep;
		this.uf = uf;
		this.dtHrConsulta = dtHrConsulta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public LocalDateTime getDtHrConsulta() {
		return dtHrConsulta;
	}
	public void setDtHrConsulta(LocalDateTime dtHrConsulta) {
		this.dtHrConsulta = dtHrConsulta;
	}
}
