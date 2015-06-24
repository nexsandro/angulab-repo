/**
 * 
 */
package br.com.jlabs.infra.rest;

import java.io.Serializable;

/**
 * @author sandro
 *
 */
public class FieldValidationError implements Serializable {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -7917918961413420125L;

    /**
     * 
     */
	private String fieldName;
	
	/**
	 * 
	 */
	private String fieldValue;
	
	/**
	 * 
	 */
	private String message;
	
	/**
	 * Default constructor.
	 */
	public FieldValidationError() {
	    super();
    }

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}

	/**
	 * @param fieldValue the fieldValue to set
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "FieldValidation [fieldName=" + fieldName + ", fieldValue="
	            + fieldValue + ", message=" + message + "]";
    }
	
}
