package br.com.redhat.leilaoweb.dominio.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.xseam.model.BaseEntity;

@Entity
@Name("usuario")
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min=5, max=80)
	private String nome;
	
	@NotNull
	@Column(unique=true)
	private String login;
	
	private int pontuacao;
	
	@OneToMany(mappedBy="vendedor")
	private List<Item> itensVendidos = new ArrayList<Item>();
	
	@OneToMany(mappedBy="comprador")
	private List<Item> itensComprados = new ArrayList<Item>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Item> getItensVendidos() {
		return itensVendidos;
	}

	public List<Item> getItensComprados() {
		return itensComprados;
	}
	
}
