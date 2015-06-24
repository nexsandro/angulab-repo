package br.com.jlabs.infra.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate3.Hibernate3Module;

/**
 * Hibernate aware mapper for hibernate serialization with Jackson JSON.
 * 
 * @author sandro
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    /**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -687001776243920715L;

    /**
     * Default constructor.
     * 
     * Used to register Hibernate 3 Module.
     */
	public HibernateAwareObjectMapper() {
    
    	registerModule(new Hibernate3Module());
    	
    }
    
}