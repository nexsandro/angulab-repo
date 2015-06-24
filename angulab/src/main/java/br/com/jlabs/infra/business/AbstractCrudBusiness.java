/**
 * 
 */
package br.com.jlabs.infra.business;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.infra.dao.CrudDao;
import br.com.jlabs.infra.persistence.Entity;
import br.com.jlabs.infra.rest.PagedSearchFilter;
import br.com.jlabs.infra.rest.PagedSearchResponse;

/**
 * @author sandro
 *
 */
public abstract class AbstractCrudBusiness<E extends Entity> implements CrudBusiness<E> {

	/**
	 * Crud Dao.
	 */
	@Autowired
	private CrudDao crudDao;

	/**
	 * Constructor with entity.
	 */
	public AbstractCrudBusiness(Class<E> entityClass) {
	    super();
	    this.entityClass = entityClass;
    }

	/**
	 * Crud Entity. 
	 */
	private Class<E> entityClass;

	/**
	 * @return the entityClass
	 */
	public Class<E> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public E get(Serializable id) {
	    return (E) crudDao.get(getEntityClass(), id);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public E get(Serializable idValue, String... joinFetchs) {
		return (E) crudDao.get(getEntityClass(), joinFetchs);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public E load(Serializable id) {
	    return (E) crudDao.load(getEntityClass(), id);
    }

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public PagedSearchResponse<E> list(PagedSearchFilter filterParams, String... joinFetchs) {
	    return crudDao.list(getEntityClass(), filterParams, joinFetchs);
    }

	/**
	 * 
	 * @param entity
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void create(E entity) {
		crudDao.create(entity);    
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public E update(E entity) {
	    return crudDao.update(entity);
    }

	/**
	 * 
	 * @param entity
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(E entity) {
		crudDao.delete(getEntityClass(), entity);
    }

	/**
	 * 
	 * @param entity
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Serializable id) {
		crudDao.delete(getEntityClass(), id);
    }

	/**
	 * @return the crudDao
	 */
	public CrudDao getCrudDao() {
		return crudDao;
	}

	/**
	 * @param crudDao the crudDao to set
	 */
	public void setCrudDao(CrudDao crudDao) {
		this.crudDao = crudDao;
	}

}
