package br.com.redhat.leilaoweb.dominio.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.xseam.model.BaseEntity;

@Entity
@Name("categoria")
public class Categoria extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min=3,max=50)
	private String nome;
	
	@OneToMany(mappedBy="categoriaPai")
	private List<SubCategoria> subCategorias = new ArrayList<SubCategoria>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}
	
}
