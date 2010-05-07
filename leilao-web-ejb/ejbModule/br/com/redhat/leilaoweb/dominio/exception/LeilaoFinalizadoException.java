package br.com.redhat.leilaoweb.dominio.exception;

public class LeilaoFinalizadoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O Leilao ja foi finalizado";
	}

}