package br.com.jlabs.infra.business;

import java.io.Serializable;

import br.com.jlabs.infra.persistence.Entity;
import br.com.jlabs.infra.rest.PagedSearchFilter;
import br.com.jlabs.infra.rest.PagedSearchResponse;

public interface CrudBusiness<E extends Entity> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	E get(Serializable id);

	/**
	 * @param idValue
	 * @param joinFetchs
	 * @return
	 */
	E get(Serializable idValue, String... joinFetchs);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	E load(Serializable id);

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	PagedSearchResponse<E> list(PagedSearchFilter searchFilter, String... joinFetchs);

	/**
	 * 
	 * @param entity
	 */
	void create(E entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	E update(E entity);

	/**
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 
	 * @param id
	 */
	void delete(Serializable id);

}