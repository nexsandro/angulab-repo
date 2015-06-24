/**
 * 
 */
package br.com.jlabs.angulab.business.keywords.uc0101_list;

import org.springframework.stereotype.Service;

import br.com.jlabs.angulab.entity.Keyword;
import br.com.jlabs.infra.business.AbstractCrudBusiness;

/**
 * @author sandro
 *
 */
@Service
public class KeywordBusinessImpl extends AbstractCrudBusiness<Keyword> implements KeywordBusiness {

	/**
	 * Default constructor.
	 */
	public KeywordBusinessImpl() {
		
		// Required by AbstractCrudBusiness to work.
	    super(Keyword.class);
	    
    }

}
