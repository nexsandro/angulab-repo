/**
 * 
 */
package br.com.jlabs.infra.rest;

import java.io.Serializable;
import java.util.List;

/**
 * @author sandro
 *
 */
public class PagedSearchResponse<T> implements Serializable {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = 7541226197137573792L;

	/**
	 * 
	 */
	private Integer itemsCount;
	
	/**
	 * 
	 */
	private List<T> data;

	public PagedSearchResponse() {
	    super();
    }
	
	public PagedSearchResponse(Integer itemsCount, List<T> data) {
	    super();
	    this.itemsCount = itemsCount;
	    this.data = data;
    }

	/**
	 * @return the itemsCount
	 */
	public Integer getItemsCount() {
		return itemsCount;
	}

	/**
	 * @param itemsCount the itemsCount to set
	 */
	public void setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "PagedSearchResponse [itemsCount=" + itemsCount + ", data="
	            + data + "]";
    }
	
}
