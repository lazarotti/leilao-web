package br.com.redhat.leilaoweb.dominio.repositorio;

import java.util.List;

import br.com.redhat.leilaoweb.dominio.entidade.Categoria;
import br.com.redhat.leilaoweb.dominio.entidade.SubCategoria;

public interface RepositorioSubCategoria extends Repositorio<SubCategoria> {

	public List<SubCategoria> recuperarPorCategoria(Categoria categoria);
}
