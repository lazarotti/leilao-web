package br.com.redhat.leilaoweb.aplicacao;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import br.com.redhat.leilaoejb.LeilaoLegado;
import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.entidade.Usuario;
import br.com.redhat.leilaoweb.dominio.exception.LanceBaixoException;
import br.com.redhat.leilaoweb.dominio.exception.LeilaoFinalizadoException;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;
import br.com.redhat.leilaoweb.infraestrutura.servicelocator.LeilaoLegadoServiceLocator;


@Name("leilaoManager")
@Scope(ScopeType.CONVERSATION)
public class LeilaoManager{	
	
	@Logger
	private Log logger;	
	
	@In
	private RepositorioProduto repositorioProduto;
	
	@In
	private Usuario usuarioLogado;
	
	@In
	private StatusMessages statusMessages;
			
	private double valorDoLanceDado;
	
	private Produto produto;
	
	
	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#darLance()
	 */
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
	
	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#finalizar()
	 */
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
		
		/* INTEGRANDO O LEGADO COM UNWRAP
		  try {
		 
			
			produto = leilaoLegado.finalizarLeilao(produto);
			repositorioProduto.armazenar(produto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} */
		

	}
	
	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#produtoSelecionado(br.com.redhat.leilaoweb.dominio.entidade.Produto)
	 */
	public void produtoSelecionado(Produto produto){
		this.produto = produto;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#setRepositorioProduto(br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto)
	 */
	public void setRepositorioProduto(RepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#getRepositorioProduto()
	 */
	public RepositorioProduto getRepositorioProduto() {
		return repositorioProduto;
	}

	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#setProduto(br.com.redhat.leilaoweb.dominio.entidade.Produto)
	 */
	public void setProduto(Produto produto) {
		System.out.println("Chamado o setProduto "+ produto);
		this.produto = produto;
	}

	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#getProduto()
	 */
	public Produto getProduto() {
		return produto;
	}
	
	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#getValorDoLanceDado()
	 */
	public double getValorDoLanceDado() {
		return valorDoLanceDado;
	}

	/* (non-Javadoc)
	 * @see br.com.redhat.leilaoweb.aplicacao.LeilaoManager#setValorDoLanceDado(double)
	 */
	public void setValorDoLanceDado(double valorDoLanceDado) {
		this.valorDoLanceDado = valorDoLanceDado;
	}
	

}
