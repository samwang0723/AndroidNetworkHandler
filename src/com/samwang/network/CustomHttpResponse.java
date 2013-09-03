package com.samwang.network;

public class CustomHttpResponse {
	
	private Object mResponse;
	private int mStatusCode;

	public Object getJsonObj() {
		return mResponse;
	}

	public void setJsonObj(Object response) {
		this.mResponse = response;
	}

	public int getStatusCode() {
		return mStatusCode;
	}

	public void setStatusCode(int mStatusCode) {
		this.mStatusCode = mStatusCode;
	}
}
