package br.com.redhat.leilaoweb.dominio.entidade;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.security.management.RoleName;
import org.xseam.model.BaseEntity;

@Entity
public class Direito extends BaseEntity{
	
	@NotNull 
	@Length(min=3, max=20)	
	@RoleName	
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
