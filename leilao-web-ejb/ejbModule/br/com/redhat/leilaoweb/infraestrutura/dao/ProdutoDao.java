package br.com.redhat.leilaoweb.infraestrutura.dao;

import java.util.List;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

import br.com.redhat.leilaoweb.dominio.entidade.Produto;
import br.com.redhat.leilaoweb.dominio.repositorio.RepositorioProduto;

@Name("repositorioProduto")
@AutoCreate
public class ProdutoDao extends BaseDao<Produto> implements RepositorioProduto {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscaPorNome(String nome) {
		return entityManager.createQuery("select produto " +
				"						 from Produto produto " +
				"				         where produto.nome like :nome")
			.setParameter("nome", "%"+nome+"%").getResultList();
	}


}
