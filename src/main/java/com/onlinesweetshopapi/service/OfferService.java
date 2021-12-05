package com.onlinesweetshopapi.service;


import com.onlinesweetshopapi.domain.Offer;


public interface OfferService {
	public Offer saveOrUpdate(Offer offer);
	public Iterable<Offer> findAllOffers();
	public Offer findOfferByOfferId(String offerId);
	public void deleteOfferByOfferId(String offerId);
		
	
}
