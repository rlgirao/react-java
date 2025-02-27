package com.embracon.teste.model.log;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="log")
public class Log {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(nullable = false, length = 8)
	private String cep;
	@Column(nullable = false, length = 2)
	private String uf;
	@Column
	private LocalDateTime dtHrConsulta;

	public Log() {
		super();
	}

	public Log(String cep, String uf, LocalDateTime dtHrConsulta) {
		super();
		this.cep = cep;
		this.uf = uf;
		this.dtHrConsulta = dtHrConsulta;
	}
	
	public Boolean isEmpty() {
		return ((this.cep == null || this.cep.isBlank()) &&
	               (this.uf == null || this.uf.isBlank()));
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
