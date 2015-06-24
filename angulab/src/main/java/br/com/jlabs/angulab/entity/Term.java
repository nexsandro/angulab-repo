/**
 * 
 */
package br.com.jlabs.angulab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author sandro
 *
 */
@Entity
@Table(name="TB_TERM")
public class Term implements br.com.jlabs.infra.persistence.Entity {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1334305142778503730L;

	private Integer id;
	
	private Keyword keyword;
	
	private Language language;
	
	private Package pack;
	
	private String text;

	public Term() {
	    super();
    }

	public Term(Integer id, Keyword keyword, Language language, Package pack, String text) {
	    this(keyword, language, pack, text);
	    this.id = id;
    }

	public Term(Keyword keyword, Language language, Package pack, String text) {
	    super();
	    this.keyword = keyword;
	    this.language = language;
		this.pack = pack;
		this.text = text;
    }


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="SE_TERM", strategy=GenerationType.AUTO)
	@SequenceGenerator(allocationSize=1, initialValue=1, name="SE_TERM", sequenceName="SE_TERM")
	@Column(name="sq_term")
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
	 * @return the pack
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_pack")
	public Package getPack() {
		return pack;
	}

	/**
	 * @param pack the pack to set
	 */
	public void setPack(Package pack) {
		this.pack = pack;
	}

	/**
	 * @return the keyword
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_keyw")
	public Keyword getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the language
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sq_lang")
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the text
	 */
	@Column(name="no_text")
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
	    Term other = (Term) obj;
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
	    return "Term [id=" + id + ", keyword=" + keyword + ", language="
	            + language + "]";
    }

}
