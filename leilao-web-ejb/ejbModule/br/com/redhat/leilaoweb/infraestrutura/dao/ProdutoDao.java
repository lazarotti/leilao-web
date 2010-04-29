package br.com.redhat.leilaoweb.infraestrutura.dao;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;

@Name("repositorioProduto")
@AutoCreate
public class ProdutoDao extends BaseDao<Produto> implements RepositorioProduto {

	private static final long serialVersionUID = 1L;


}
