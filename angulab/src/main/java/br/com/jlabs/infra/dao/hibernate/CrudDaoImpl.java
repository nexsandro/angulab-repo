/**
 * 
 */
package br.com.jlabs.infra.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.jlabs.infra.dao.CrudDao;
import br.com.jlabs.infra.persistence.Entity;
import br.com.jlabs.infra.rest.PagedSearchFilter;
import br.com.jlabs.infra.rest.PagedSearchResponse;

/**
 * @author sandro
 *
 */
@Repository("crudDao")
public class CrudDaoImpl implements CrudDao {

	/**
	 * Injected Hibernate Session Factory;
	 */
	protected SessionFactory sessionFactory;

	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#get(java.lang.Class, long)
	 */
	public <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}
	
	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#load(java.lang.Class, java.io.Serializable)
	 */
	public <T extends Entity> T load(Class<T> clazz, Serializable id) {
		return (T) getCurrentSession().load(clazz, id);
	}
	
	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#get(java.lang.Class, java.lang.String, java.io.Serializable, java.lang.String)
	 */
	public <T extends Entity> T get(Class<T> clazz, Serializable id, String ... joinFetchs) {

		Criteria criteria = createJoinedCriteria(clazz, joinFetchs);
		
		criteria.add(Restrictions.idEq(id));
		
		for(String joinFetch : joinFetchs) {
			criteria.setFetchMode(joinFetch, FetchMode.JOIN);
		}
		
		return (T) criteria.uniqueResult();
	}

	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#list(java.lang.Class)
	 */
	public <T extends Entity> List<T> list(Class<T> clazz) {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}
	
	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#list(java.lang.Class, java.lang.String)
	 */
	public <T extends Entity> PagedSearchResponse<T> list(Class<T> clazz, PagedSearchFilter filterParams, String ... joinFetchs) {

		Criteria criteria = createJoinedCriteria(clazz, new String[] {});
		
		Integer itemsCount = ((Number) criteria
			.setProjection(Projections.rowCount())
			.uniqueResult())
			    .intValue();
		
		criteria = createJoinedCriteria(clazz, new String[] {});
		
		List<T> data = criteria
			.setFirstResult((filterParams.getPageNumber() - 1) * filterParams.getPageSize())
			.setMaxResults(filterParams.getPageSize())
			.list();

		return new PagedSearchResponse<T>(itemsCount, data);
	}

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	private <T extends Entity> Criteria createJoinedCriteria(Class<T> clazz, String... joinFetchs) {
		Session currentSession = getCurrentSession();
		Criteria criteria = currentSession.createCriteria(clazz);
		
		for(String joinFetch: joinFetchs) {
			criteria.setFetchMode(joinFetch, FetchMode.JOIN);
		}
		return criteria;
	}
	
	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#create(T)
	 */
	public <T extends Entity> void create(T entity) {
		getCurrentSession().persist(entity);
	}

	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#update(T)
	 */
	public <T extends Entity> T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#delete(T)
	 */
	public <T extends Entity> void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	/**
	 * @see br.com.jlabs.publish.dao.hibernate.ICrud#deleteById(java.lang.Class, long)
	 */
	public <T extends Entity> void delete(Class<T> clazz, Serializable entityId) {
		T entity = load(clazz, entityId);
		delete(entity);
	}

	/**
	 * 
	 * @return
	 */
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
