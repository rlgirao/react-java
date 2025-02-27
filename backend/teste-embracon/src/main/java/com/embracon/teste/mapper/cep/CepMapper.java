package com.embracon.teste.mapper.cep;

import com.embracon.teste.dto.cep.CepDTO;
import com.embracon.teste.dto.cep.CepRetornoApiDTO;

public class CepMapper {
	
	private CepMapper() {
		super();
	}

	public static CepDTO fromCEPRetornoApiDTOToCepDTO(CepRetornoApiDTO response) {
		return new CepDTO(response.cep(), response.logradouro(), response.bairro(), response.localidade(),
				response.uf());
	}
}
