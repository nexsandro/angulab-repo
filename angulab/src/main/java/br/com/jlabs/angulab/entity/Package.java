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
@Table(name="TB_PACK")
public class Package implements br.com.jlabs.infra.persistence.Entity {

	/**
	 * 
	 */
    private static final long serialVersionUID = -1062690876559052339L;

	private Integer id;
	
	private String name;

	public Package() {
	    super();
    }

	public Package(Integer id, String name) {
	    this(name);
	    this.id = id;
    }

	public Package(String name) {
	    super();
	    this.name = name;
    }

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="SE_PACK", strategy=GenerationType.AUTO)
	@SequenceGenerator(allocationSize=1, initialValue=1, name="SE_PACK", sequenceName="SE_PACK")
	@Column(name="sq_pack")
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
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	    Package other = (Package) obj;
	    if (id == null) {
		    if (other.id != null)
			    return false;
	    } else if (!id.equals(other.id))
		    return false;
	    if (name == null) {
		    if (other.name != null)
			    return false;
	    } else if (!name.equals(other.name))
		    return false;
	    return true;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "Package [id=" + id + ", name=" + name + "]";
    }

}
