/**
 * 
 */
package br.com.jlabs.infra.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandro
 *
 */
public class ApplicationError implements Serializable {

	/**
	 * serialVersionUID.
	 */
    private static final long serialVersionUID = -3967989582444708599L;

    /**
     * Exception text explaing.
     */
	private String message;
	
	/**
	 * Exception params.
	 */
	private Object[] params;
	
	/**
	 * This exception stacktrace.
	 */
	private List<String> stackTrace;
	
	/**
	 * Default constructor.
	 */
	public ApplicationError() {
	    
		super();
	    setStackTrace( new ArrayList<String>() );
	    
    }
	
	public static ApplicationError fromException(Exception e) {
		
		ApplicationError result = new ApplicationError();
		result.setMessage(e.getClass().getCanonicalName());
		
		for (StackTraceElement stackTraceElement : e.getStackTrace()) {
			result.getStackTrace().add(stackTraceElement.toString());
        }
		
		return result;
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

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}

	/**
	 * @return the stackTrace
	 */
	public List<String> getStackTrace() {
		return stackTrace;
	}

	/**
	 * @param stackTrace the stackTrace to set
	 */
	public void setStackTrace(List<String> stackTrace) {
		this.stackTrace = stackTrace;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "ApplicationError [message=" + message + ", params="
	            + Arrays.toString(params) + ", stackTrace=" + stackTrace + "]";
    }
	
}
