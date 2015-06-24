package br.com.jlabs.infra.dao;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.infra.persistence.Entity;
import br.com.jlabs.infra.rest.PagedSearchFilter;
import br.com.jlabs.infra.rest.PagedSearchResponse;

/**
 * 
 * @author sandro
 *
 */
public interface CrudDao {

	/**
	 * 
	 * @param id
	 * @return
	 */
	<T extends Entity> T get(Class<T> clazz, Serializable id);

	/**
	 * 
	 * @param idField
	 * @param idValue
	 * @param joinFetchs
	 * @return
	 */
	<T extends Entity> T get(Class<T> clazz, Serializable id, String... joinFetchs);
	
	/**
	 * Load an entity
	 * @param id
	 * @return
	 */
	<T extends Entity> T load(Class<T> clazz, Serializable id);

	/**
	 * 
	 * @return
	 */
	<T extends Entity> List<T> list(Class<T> clazz);

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	<T extends Entity> PagedSearchResponse<T> list(Class<T> clazz, PagedSearchFilter filterParams, String... joinFetchs);

	/**
	 * 
	 * @param entity
	 */
	<T extends Entity> void create(T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	<T extends Entity> T update(T entity);

	/**
	 * 
	 * @param entity
	 */
	<T extends Entity> void delete(T entity);

	/**
	 * 
	 * @param entityId
	 */
	<T extends Entity> void delete(Class<T> clazz, Serializable entityId);

}