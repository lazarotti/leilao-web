package br.com.redhat.leilaoweb.dominio.entidade;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.xseam.model.BaseEntity;

@Entity
public class Direito extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@NotNull 
	@Length(min=3, max=20)	
	private String nome;
	
	@NotNull 
	@Length(min=5, max=80)		
	private String descricao;
	
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
	
	

}
