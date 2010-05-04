package br.com.redhat.leilaoweb.dominio.repositorio;

import java.util.List;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;

public interface RepositorioProduto extends Repositorio<Produto> {
	
	
	public List<Produto> buscaPorNome(String nome);

}
