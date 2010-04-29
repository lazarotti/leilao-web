package br.com.redhat.leilaoweb.aplicacao;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.redhat.leilaoweb.dominio.entidade.Categoria;
import br.com.redhat.leilaoweb.dominio.repositorio.MuitosResultadosException;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioCategoria;

@Name("combosEstaticos")
@Scope(ScopeType.APPLICATION)
public class CombosEstaticos {
	
	@In
	private RepositorioCategoria repositorioCategoria;
	
	@Factory(value="comboCategorias", scope=ScopeType.APPLICATION)
	public List<Categoria> getCategorias() throws MuitosResultadosException{
		return repositorioCategoria.recuperarTodos();
	}

}
