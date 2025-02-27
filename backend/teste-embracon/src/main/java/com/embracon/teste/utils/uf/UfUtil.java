package com.embracon.teste.utils.uf;

public class UfUtil {

	private UfUtil() {
		super();
	}
	
	public static void validarUf(String uf) {
	    if (uf == null || uf.isBlank() || !isUfValido(uf)) {
	        throw new IllegalArgumentException("UF inválida.");
	    }
	}

	public static boolean isUfValido(String uf) {
	    return uf != null && uf.matches("[A-Z]{2}");
	}
}
