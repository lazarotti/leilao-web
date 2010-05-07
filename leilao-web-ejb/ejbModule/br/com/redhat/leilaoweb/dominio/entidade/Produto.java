package br.com.redhat.leilaoweb.dominio.entidade;

import static javax.persistence.EnumType.STRING;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Role;
import org.jboss.seam.annotations.Scope;
import org.xseam.model.BaseEntity;

import br.com.redhat.leilaoweb.dominio.exception.LanceBaixoException;
import br.com.redhat.leilaoweb.dominio.exception.LeilaoFinalizadoException;
import br.com.redhat.leilaoweb.dominio.vo.Imagem;

@Entity
@Name("produto")
@Role(name="produtoFiltro")
@AutoCreate
public class Produto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Length(min = 3, max = 50)
	private String nome;

	@Length(min = 3, max = 200)
	private String descricao;
	
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL)
	private List<Lance> lances = new ArrayList<Lance>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	@ManyToOne
	private Usuario vendedor;

	@ManyToOne
	private Usuario comprador;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private SubCategoria subCategoria;
	
	@Embedded
	private Imagem imagem;
	
	public enum Status{
		ATIVO("Ativo"),FINALIZADO("Finalizado");
		private String descricao;		 
			     private Status(String descricao) {
			          this.descricao = descricao;
			     }
			     public String getDescricao() {
			           return descricao;
			     }
	}
	
	@Enumerated(STRING)	
	private Status status;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Lance lanceAtual;
			
	public Lance getLanceAtual() {
		return lanceAtual;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Usuario getComprador() {
		return comprador;
	}
	
	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public List<Lance> getLances() {
		return lances;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean estaFinalizado(){
		return status == Status.FINALIZADO;
	}
	
	public void adicionarPrimeiroLance(Usuario usuario, double valorDolance) throws LeilaoFinalizadoException{
		try {
			this.vendedor = usuario;
			adicionarLance(usuario, valorDolance);
			this.status= Status.ATIVO;
		} catch (LanceBaixoException e) {
			//essa excecao nunca acontece para o primeiro lance
		}
	}
	
	public void adicionarLance(Usuario usuario, double valorDolance) throws LanceBaixoException, LeilaoFinalizadoException{		
		if( lanceAtual != null && valorDolance < lanceAtual.getValor() ){
			throw new LanceBaixoException();
		}
		
		if(this.getDataFim().before(new Date())){
			throw new LeilaoFinalizadoException();
		}
		
		Lance  novoLance = new Lance(this,usuario,valorDolance);
		this.lances.add(novoLance);
		this.lanceAtual = novoLance;
	}
	
	public void finalizarLeilao(){
		this.comprador = lanceAtual.getUsuario();
		this.status = Status.FINALIZADO;
		this.dataFim = new Date();
	}

}
