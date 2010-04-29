package br.com.redhat.leilaoweb.aplicacao;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;

@Name("produtoManager")
@Scope(ScopeType.CONVERSATION)
public class ProdutoManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@In
	@Out(required=false) // remover e novo
	private Produto produto;

	@In
	private RepositorioProduto repositorioProduto;

	@In
	private StatusMessages statusMessages;

	public void salvar() {
		repositorioProduto.armazenar(produto);
		statusMessages.add(Severity.INFO, "Item #{item.nome} salvo com sucesso!");
	}

	public void atualizar() {
		repositorioProduto.armazenar(produto);
		statusMessages.add(Severity.INFO, "Item #{item.nome} atualizado com sucesso!");
	}

	public void remover() {
		repositorioProduto.remover(produto);
		statusMessages.add(Severity.INFO, "Item #{item.nome} removido com sucesso!");
		produto = null;
	}

	public void novo() {
		produto = null;
	}
}
