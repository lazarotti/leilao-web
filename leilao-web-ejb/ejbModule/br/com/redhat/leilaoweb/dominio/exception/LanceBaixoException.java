package br.com.redhat.leilaoweb.dominio.exception;

public class LanceBaixoException extends Exception{

	@Override
	public String getMessage() {
		return "O lance dado eh menor do que o corrente";
	}
	
}
