package com.onlinesweetshopapi.exception;

public class SweetIDExceptionResponse {
	
	private String sweetIdentifer;
	
	public SweetIDExceptionResponse(String sweetIdentifer) {
		super();
		this.sweetIdentifer = sweetIdentifer;
	}

	public String getSweetIdentifer() {
		return sweetIdentifer;
	}

	public void setSweetIdentifer(String sweetIdentifer) {
		this.sweetIdentifer = sweetIdentifer;
	}
	
	
}
