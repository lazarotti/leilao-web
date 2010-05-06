package br.com.redhat.leilaoweb.dominio.exception;

public class LeilaoFinalizadoException extends Exception {

	@Override
	public String getMessage() {
		return "O Leilao ja foi finalizado";
	}

}