package com.onlinesweetshopapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Offer;
import com.onlinesweetshopapi.exception.OfferIdException;
import com.onlinesweetshopapi.exception.OrderIdException;
import com.onlinesweetshopapi.repository.OfferRepository;
import com.onlinesweetshopapi.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	private OfferRepository offerRepository;
	
	public Offer saveOrUpdate(Offer offer) throws OrderIdException {
		// TODO Auto-generated method stub
		try {
			offer.setOfferId(offer.getOfferId().toUpperCase());
		return offerRepository.save(offer);
		}
		catch(Exception e)
		{
			throw new OfferIdException("Offer Id" + offer.getOfferId()+ " is already available");
		}
	}

	@Override
	public Iterable<Offer> findAllOffers() {
		return offerRepository.findAll();
	}

	@Override
	public Offer findOfferByOfferId(String offerId) {
		// TODO Auto-generated method stub
		Offer offer= offerRepository.findByOfferId(offerId);
		return offer;
	}
		

	@Override
	public void deleteOfferByOfferId(String offerId) {
		Offer offer= offerRepository.findByOfferId(offerId.toUpperCase());
		if(offer==null) {
			throw new OfferIdException("Can not delete offer with offer id "+offerId.toUpperCase()+". This id does not exist");
		}
		
		offerRepository.delete(offer);
	}
}
