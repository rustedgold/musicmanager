package com.ea.music.rmgr.model;

public class MusicMgrHeader {

	private String requestId;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;

	@Override
	public String toString() {
		return "MusicMgrHeader [requestId=" + requestId + ", status=" + status + ", getRequestId()=" + getRequestId()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
