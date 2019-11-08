package com.ea.music.rmgr.exception;

/**
 * Custom exception to handle 
 * issues with the processing
 *
 */
public class TechnicalException extends Exception {
	private String requestid;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TechnicalException(String errorMessage) {
		super(errorMessage);
	}

	public TechnicalException(String errorMessage, String requestid) {
		super(errorMessage);
		this.requestid = requestid;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
}
