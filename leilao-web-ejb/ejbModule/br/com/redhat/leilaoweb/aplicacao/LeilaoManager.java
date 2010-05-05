package br.com.redhat.leilaoweb.aplicacao;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.entidade.Usuario;
import br.com.redhat.leilaoweb.dominio.exception.LanceBaixoException;
import br.com.redhat.leilaoweb.dominio.exception.LeilaoFinalizadoException;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;


@Name("leilaoManager")
@Scope(ScopeType.CONVERSATION)
public class LeilaoManager{	
	
	@In
	private RepositorioProduto repositorioProduto;
	
	@In
	private Usuario usuarioLogado;
	
	@In
	private StatusMessages statusMessages;
	
	private double valorDoLanceDado;
	
	private Produto produto;
	
	public void darLance(){
		try {
			
			produto.adicionarLance(usuarioLogado, valorDoLanceDado);
			repositorioProduto.armazenar(produto);
			statusMessages.add(Severity.INFO, "Lance efetivado com sucesso");
			
		} catch (LanceBaixoException e) {
			statusMessages.add(Severity.ERROR, "Seu lance é menor do que o lance atual. Tente outro.");				
		} catch (LeilaoFinalizadoException e) {
			statusMessages.add(Severity.ERROR, "Este leilão já foi finalizado");				
		}
	}
	
	public void finalizar(){
		
		produto.finalizarLeilao();
		repositorioProduto.armazenar(produto);		
		
		/* CODIGO ALTERNATIVO INVOCANDO UM EJB2 REMOTO
		LeilaoLegadoServiceLocator serviceLocator = new LeilaoLegadoServiceLocator();
		try {
			
			produto =  serviceLocator.getHome().create().finalizarLeilao(produto);
			repositorioProduto.armazenar(produto);			
			
		} catch (Exception e) {
			statusMessages.add(Severity.ERROR,"Erro na invocacao do EJB Legado ");
			e.printStackTrace();
		}*/

	}
	
	public void produtoSelecionado(Produto produto){
		this.produto = produto;
	}
	
	
	public void setRepositorioProduto(RepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	public RepositorioProduto getRepositorioProduto() {
		return repositorioProduto;
	}

	public void setProduto(Produto produto) {
		System.out.println("Chamado o setProduto "+ produto);
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public double getValorDoLanceDado() {
		return valorDoLanceDado;
	}

	public void setValorDoLanceDado(double valorDoLanceDado) {
		this.valorDoLanceDado = valorDoLanceDado;
	}
	


}
