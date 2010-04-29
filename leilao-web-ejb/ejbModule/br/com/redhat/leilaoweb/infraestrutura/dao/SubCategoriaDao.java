package br.com.redhat.leilaoweb.infraestrutura.dao;

import java.util.List;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

import br.com.redhat.leilaoweb.dominio.entidade.Categoria;
import br.com.redhat.leilaoweb.dominio.entidade.SubCategoria;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioSubCategoria;

@Name("repositorioSubCategoria")
@AutoCreate
public class SubCategoriaDao extends BaseDao<SubCategoria> implements RepositorioSubCategoria {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategoria> recuperarPorCategoria(Categoria categoria) {
		return entityManager.createNamedQuery("subCategoria.findByCategoria").setParameter("categoriaPai",categoria).getResultList();
	}


}
