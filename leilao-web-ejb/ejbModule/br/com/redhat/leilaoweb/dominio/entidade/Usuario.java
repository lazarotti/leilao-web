package br.com.redhat.leilaoweb.dominio.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Role;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;
import org.xseam.model.BaseEntity;

@Entity
@Name("usuario")
@Role(name="usuarioLogado")
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull 
	@Length(min=5, max=80)
	private String nome;
	
	@NotNull
	@Column(unique=true)
	@UserPrincipal	
	private String login;
	
	@NotNull
	@Length(min=4, max=7)
	@UserPassword(hash="none")		
	private String senha;
	
	@Email
	private String email;
	
	private String endereco;
		
	private int pontuacao;
	
	@OneToMany(mappedBy="vendedor")
	private List<Produto> itensVendidos = new ArrayList<Produto>();
	
	@OneToMany(mappedBy="comprador")
	private List<Produto> itensComprados = new ArrayList<Produto>();
		
	@ManyToMany(targetEntity = Direito.class)
	@JoinTable(name = "UsuarioDireito", 
	   joinColumns = @JoinColumn(name = "usuarioId"),
	   inverseJoinColumns = @JoinColumn(name = "direitoId"))
	@UserRoles	   
	private List<Direito> direitos;

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

	public List<Produto> getItensVendidos() {
		return itensVendidos;
	}

	public List<Produto> getItensComprados() {
		return itensComprados;
	}

	public void setDireitos(List<Direito> direitos) {
		this.direitos = direitos;
	}

	public List<Direito> getDireitos() {
		return direitos;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
}
