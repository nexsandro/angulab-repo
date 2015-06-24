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
@Table(name="TB_LANG")
public class Language implements br.com.jlabs.infra.persistence.Entity {

	/**
	 * 
	 */
    private static final long serialVersionUID = -3757736547565563743L;

	private Integer id;
	
	private String name;

	public Language() {
	    super();
    }

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="SE_LANG", strategy=GenerationType.AUTO)
	@SequenceGenerator(allocationSize=1, initialValue=1, name="SE_LANG", sequenceName="SE_LANG")
	@Column(name="sq_lang")
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
	 * @return the name
	 */
	@Column(name="no_name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "Language [id=" + id + ", name=" + name + "]";
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
	    Language other = (Language) obj;
	    if (id == null) {
		    if (other.id != null)
			    return false;
	    } else if (!id.equals(other.id))
		    return false;
	    return true;
    }

}
