package com.onlinesweetshopapi.exception;

public class OfferIdExceptionResponse {

	private String offerId;

	public OfferIdExceptionResponse(String offerId) {
		super();
		this.offerId = offerId;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	
	
}
