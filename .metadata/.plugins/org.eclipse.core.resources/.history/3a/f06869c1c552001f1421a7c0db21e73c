package br.com.redhat.leilaoweb.infraestrutura.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.xseam.model.BaseEntity;

import br.com.redhat.leilaoweb.dominio.repositorio.MuitosResultadosException;
import br.com.redhat.leilaoweb.dominio.repositorio.Repositorio;


public abstract class BaseDao<T extends BaseEntity> implements Repositorio<T> {

	private static final long serialVersionUID = 1L;

	@In
	protected EntityManager entityManager;

	private Class<T> persistenceClazz = null;

	@Override
	public void remover(T entidade) {
		entityManager.remove(entidade);
		entityManager.flush();
	}

	@Override
	public void armazenar(T entidade) {
		entityManager.persist(entidade);
		entityManager.flush();
	}

	@Override
	public T recuperarPorId(Long id) {
		return entityManager.find(getPersistenceClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> recuperarTodos() throws MuitosResultadosException {
		List<T> retorno = entityManager.createQuery("SELECT c FROM " + getPersistenceClass().getSimpleName() + " c").setMaxResults(50).getResultList();
		if (retorno.size() >= 50) {
			throw new MuitosResultadosException();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperarTodosSemLimite() {
		List<T> retorno = entityManager.createQuery("SELECT c FROM " + getPersistenceClass().getSimpleName() + " c").getResultList();
		return retorno;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getPersistenceClass() {
		if (persistenceClazz == null) {
			persistenceClazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return persistenceClazz;
	}

}
