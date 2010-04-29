package br.com.redhat.leilaoweb.infraestrutura.dao;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

import br.com.redhat.leilaoweb.dominio.entidade.Categoria;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioCategoria;

@Name("repositorioCategoria")
@AutoCreate
public class CategoriaDao extends BaseDao<Categoria> implements RepositorioCategoria {

	private static final long serialVersionUID = 1L;


}
