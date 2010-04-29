package br.com.redhat.leilaoweb.aplicacao;

import java.io.Serializable;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.redhat.leilaoweb.dominio.entidade.Categoria;
import br.com.redhat.leilaoweb.dominio.entidade.SubCategoria;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioSubCategoria;

@Name("subCategoriaManager")
@Scope(ScopeType.CONVERSATION)
public class SubCategoriaManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@In
	private RepositorioSubCategoria repositorioSubCategoria;
	
	public List<SubCategoria> recuperarSubCategoriasByCategoria(Categoria categoria){
		return repositorioSubCategoria.recuperarPorCategoria(categoria);
	}

	
}