package br.com.redhat.leilaoweb.dominio.repositorio;

import java.io.Serializable;
import java.util.List;

import org.xseam.model.BaseEntity;


public interface Repositorio<T extends BaseEntity> extends Serializable {

	void armazenar(T entidade);

	T recuperarPorId(Long id);

	List<T> recuperarTodos() throws MuitosResultadosException;

	void remover(T entidade);

}
