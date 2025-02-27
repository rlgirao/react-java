package com.embracon.teste.utils.cep;

public class CepUtil {

	private CepUtil() {
		super();
	}

	public static void validarCep(String cep) {
	    if (cep == null || cep.isBlank() || !isCepValido(cep)) {
	        throw new IllegalArgumentException("CEP inválido.");
	    }
	}

	public static boolean isCepValido(String cep) {
	    return cep != null && cep.matches("\\d{8}");
	}

}
