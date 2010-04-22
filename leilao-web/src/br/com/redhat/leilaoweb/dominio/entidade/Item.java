package br.com.redhat.leilaoweb.dominio.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Length;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.xseam.model.BaseEntity;

@Entity
@Name("item")
public class Item extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Length(min = 3, max = 50)
	private String nome;

	@Length(min = 3, max = 200)
	private String descricao;

	@Min(0)
	private int precoInicial;

	@Min(0)
	private int precoReserva;

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

	public int getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(int precoInicial) {
		this.precoInicial = precoInicial;
	}

	public int getPrecoReserva() {
		return precoReserva;
	}

	public void setPrecoReserva(int precoReserva) {
		this.precoReserva = precoReserva;
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
}
