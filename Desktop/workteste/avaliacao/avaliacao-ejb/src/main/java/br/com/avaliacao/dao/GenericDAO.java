package br.com.avaliacao.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.avaliacao.exception.AvaliacaoAcessoADadosException;

public abstract class GenericDAO<T, I extends Serializable> {

	static final Logger logger = LogManager.getLogger(GenericDAO.class);

	private final static String UNIT_NAME = "bdUnit";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T salvar(@Valid T entity) throws AvaliacaoAcessoADadosException {
		try {
			entityManager.persist(entity);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}
		return entity;

	}

	public T atualizar(@Valid T entity) throws AvaliacaoAcessoADadosException {
		try {
			entityManager.merge(entity);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}
		return entity;
	}

	public void remover(I id) throws AvaliacaoAcessoADadosException {
		try {
			T entity = encontrar(id);
			T mergedEntity = entityManager.merge(entity);
			entityManager.remove(mergedEntity);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}
	}

	public List<T> getList() throws AvaliacaoAcessoADadosException {
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(persistedClass);
			query.from(persistedClass);
			return entityManager.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}

	}

	public T encontrar(I id) throws AvaliacaoAcessoADadosException {
		try {
			return entityManager.find(persistedClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> executeNamedQuery(String namedQuery, Map<String, Object> parameters) throws AvaliacaoAcessoADadosException  {
		List<T> result = null;

		try {
			Query query = entityManager.createNamedQuery(namedQuery);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (List<T>) query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new AvaliacaoAcessoADadosException();
		}
		return result;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {

		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}