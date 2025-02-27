package com.embracon.teste.dto.log;

public class RetornoConsultaLogDTO {
	private String uf;
	private String dtHrConsulta;

	public RetornoConsultaLogDTO() {
		super();
	}
	
	public RetornoConsultaLogDTO(String uf, String dtHrConsulta) {
		super();
		this.uf = uf;
		this.dtHrConsulta = dtHrConsulta;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDtHrConsulta() {
		return dtHrConsulta;
	}
	public void setDtHrConsulta(String dtHrConsulta) {
		this.dtHrConsulta = dtHrConsulta;
	}
}
