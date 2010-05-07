package br.com.redhat.leilaoweb.aplicacao;

import java.io.FileNotFoundException;
import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.entidade.Usuario;
import br.com.redhat.leilaoweb.dominio.exception.LeilaoFinalizadoException;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;
import br.com.redhat.leilaoweb.dominio.vo.Imagem;

@Name("produtoManager")
@Scope(ScopeType.CONVERSATION)
public class ProdutoManager implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@In
	@Out(required=false) // remover e novo
	private Produto produto;
	
	private double lanceInicial;
	
	@In
	private Usuario usuarioLogado;
	
	@In
	private RepositorioProduto repositorioProduto;

	@In
	private StatusMessages statusMessages;
	
	private Imagem imagem = new Imagem();
	
	public void imagemUpload(UploadEvent event) throws FileNotFoundException{
        UploadItem item = event.getUploadItem();
        imagem.setTamanho(item.getFileSize());
        imagem.setNome(item.getFileName());
        imagem.setDados(item.getData());
        produto.setImagem(imagem);
	}
		
	public void salvar() {
		try {
			
			//lance inicial dado pelo proprio vendedor			
			produto.adicionarPrimeiroLance(usuarioLogado, lanceInicial);
			
			repositorioProduto.armazenar(produto);
			statusMessages.add(Severity.INFO, "Item #{item.nome} salvo com sucesso!");			
		} catch (LeilaoFinalizadoException e) {
			statusMessages.add(Severity.ERROR, "A data final é menor do que o dia de hoje. Tente outra data.");			
		}
	}

	public void atualizar() {
		try {		
		//lance inicial dado pelo proprio vendedor			
		produto.adicionarPrimeiroLance(usuarioLogado, lanceInicial);	
		
		repositorioProduto.armazenar(produto);
		statusMessages.add(Severity.INFO, "Item #{item.nome} atualizado com sucesso!");
		} catch (LeilaoFinalizadoException e) {
			statusMessages.add(Severity.ERROR, "A data final é menor do que o dia de hoje. Tente outra data.");			
		}		
	}

	public void remover() {
		repositorioProduto.remover(produto);
		statusMessages.add(Severity.INFO, "Item #{item.nome} removido com sucesso!");
		produto = null;
	}

	public void novo() {
		produto = null;
	}
	
	//getters and setters

	public void setLanceInicial(double lanceInicial) {
		this.lanceInicial = lanceInicial;
	}

	public double getLanceInicial() {
		return lanceInicial;
	}
}
