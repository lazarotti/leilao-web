package br.com.redhat.leilaoweb.dominio.entidade;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.xseam.model.BaseEntity;

@Entity
@Name("subCategoria")
public class SubCategoria extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min=3,max=50)
	private String nome;
	
	@ManyToOne
	@NotNull
	private Categoria categoriaPai;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
	
}
