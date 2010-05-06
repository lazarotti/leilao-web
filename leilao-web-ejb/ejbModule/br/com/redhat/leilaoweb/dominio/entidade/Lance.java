package br.com.redhat.leilaoweb.dominio.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.xseam.model.BaseEntity;

@Entity
public class Lance extends BaseEntity{
	
	public Lance(){
		
	}	
	
	public Lance(Produto produto, Usuario usuario, double valor) {
		super();
		this.produto = produto;
		this.usuario = usuario;
		this.valor = valor;
	}

	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Usuario usuario;
	
	private double valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	private boolean vencedor = false;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public boolean isVendedor(){
		return vencedor;
	}
	
	public void setVencedor(){
		
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
}
