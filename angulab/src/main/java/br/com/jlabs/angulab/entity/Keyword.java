/**
 * 
 */
package br.com.jlabs.angulab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author sandro
 *
 */
@Entity
@Table(name="TB_KEYW")
public class Keyword implements br.com.jlabs.infra.persistence.Entity {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6878847220412796795L;

	private Integer id;
	
	private String key;
	
	private String description;

	public Keyword() {
	    super();
	}
	
	public Keyword(Integer id, String key, String description) {
	    super();
	    this.id = id;
	    this.key = key;
	    this.description = description;
    }

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="SE_KEYW", strategy=GenerationType.AUTO)
	@SequenceGenerator(allocationSize=1, initialValue=1, name="SE_KEYW", sequenceName="SE_KEYW")
	@Column(name="sq_keyw")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	@Column(name="no_key")
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the description
	 */
	@Column(name="no_desc")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Keyword other = (Keyword) obj;
	    if (id == null) {
		    if (other.id != null)
			    return false;
	    } else if (!id.equals(other.id))
		    return false;
	    return true;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "Keyword [id=" + id + ", key=" + key + ", description="
	            + description + "]";
    }

}
