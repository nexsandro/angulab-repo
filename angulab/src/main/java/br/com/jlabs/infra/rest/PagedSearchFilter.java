package br.com.jlabs.infra.rest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PagedSearchFilter implements Serializable {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -446070075509438845L;

    /**
     * Expected result page number.
     */
	private Integer pageNumber;
	
	/**
	 * Expected result page size.
	 */
	private Integer pageSize;

	/**
	 * Query filter params.
	 */
	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 
	 */
	public PagedSearchFilter() {
	    super();
    }
	
	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 */
	public PagedSearchFilter(Integer pageNumber, Integer pageSize) {
	    super();
	    this.pageNumber = pageNumber;
	    this.pageSize = pageSize;
    }

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void addFilterParam(String key, Object value) {
		getParams().put(key, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "PagedSearch [pageNumber=" + pageNumber + ", pageSize="
	            + pageSize + ", params="
	            + params + "]";
    }

}
