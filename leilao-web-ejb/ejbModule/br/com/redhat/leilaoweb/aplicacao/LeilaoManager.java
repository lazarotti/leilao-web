package br.com.redhat.leilaoweb.aplicacao;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;

public interface LeilaoManager {

	public abstract void darLance();

	public abstract void finalizar();

	public abstract void produtoSelecionado(Produto produto);

	public abstract void setRepositorioProduto(
			RepositorioProduto repositorioProduto);

	public abstract RepositorioProduto getRepositorioProduto();

	public abstract void setProduto(Produto produto);

	public abstract Produto getProduto();

	public abstract double getValorDoLanceDado();

	public abstract void setValorDoLanceDado(double valorDoLanceDado);
	
	public abstract void destroy();

}