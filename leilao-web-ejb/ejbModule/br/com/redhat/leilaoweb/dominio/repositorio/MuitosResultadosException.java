package br.com.redhat.leilaoweb.dominio.repositorio;

public class MuitosResultadosException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MuitosResultadosException(String message) {
		super(message);
	}

	public MuitosResultadosException() {
		super(
				"Foram retornados mais de 50 resultados. Por favor, refine a sua busca.");
	}
}
