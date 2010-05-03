package br.com.redhat.leilaoweb.aplicacao;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;


@Name("leilaoManager")
@Scope(ScopeType.CONVERSATION)
public class LeilaoManager{
	
	@In
	private RepositorioProduto repositorioProduto;
	
	@In
	private Produto produto;
	
	
	

	public void setRepositorioProduto(RepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	public RepositorioProduto getRepositorioProduto() {
		return repositorioProduto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}	
	
	

}
