package br.com.redhat.leilaoweb.dominio.exception;

public class LanceBaixoException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O lance dado eh menor do que o corrente";
	}
	
}
