package com.deborateste.gerenciadorLivros.exceptions;

public class NaoAutorizadoException extends RuntimeException {
	public NaoAutorizadoException(String message) {
		super(message);
	}
}
