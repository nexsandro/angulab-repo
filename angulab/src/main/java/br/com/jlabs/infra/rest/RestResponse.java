/**
 * 
 */
package br.com.jlabs.infra.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sandro
 *
 */
public class RestResponse implements Serializable {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -2379728772764106578L;

	public static final String SUCCESS = "SUCCESS";
	
	public static final String ERROR = "ERROR";
	
	private String ack;
	
	private Object data;
	
	private List<ApplicationError> applicationErrors;
	
	private List<FieldValidationError> fieldValidationErrors;

	/**
	 * 
	 * @param ack
	 */
	private RestResponse(String ack) {
		super();
		setAck(ack);
	}
	
	/**
	 * Default constructor.
	 */
	private RestResponse() {
	    this(ERROR);
    }	

	/**
	 * Default constructor.
	 */
	private RestResponse(String ack, Object data) {
	    super();
	    setAck(ack);
	    setData(data);
    }

	/**
	 * @param data
	 * @return
	 */
	public static RestResponse success(Object data) {
		return new RestResponse(SUCCESS, data);
	}

	/**
	 * 
	 * @param applicationError
	 * @return
	 */
	public static RestResponse error(ApplicationError applicationError) {
		
		RestResponse result = new RestResponse(ERROR);
		result.addApplicationError(applicationError);
		
		return result;
		
	}

	/**
	 * @param applicationError
	 */
	public void addApplicationError(ApplicationError applicationError) {

		if (applicationErrors == null)
			applicationErrors = new ArrayList<ApplicationError>();
		
		applicationErrors.add(applicationError);
		
	}
	/**
	 * @param applicationError
	 */
	public void addFieldValidationError(FieldValidationError fieldValidationError) {

		if (fieldValidationErrors == null)
			fieldValidationErrors = new ArrayList<FieldValidationError>();
		
		fieldValidationErrors.add(fieldValidationError);
		
	}
	
	/**
	 * @return the ack
	 */
	public String getAck() {
		return ack;
	}

	/**
	 * @param ack the ack to set
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the applicationErrors
	 */
	public List<ApplicationError> getApplicationErrors() {
		return applicationErrors;
	}

	/**
	 * @return the fieldValidationErrors
	 */
	public List<FieldValidationError> getFieldValidationErrors() {
		return fieldValidationErrors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "RestResponse [ack=" + ack + ", data=" + data
	            + ", applicationErrors=" + applicationErrors
	            + ", fieldValidationErrors=" + fieldValidationErrors + "]";
    }
	
}
