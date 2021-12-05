package com.onlinesweetshopapi.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Category;
import com.onlinesweetshopapi.domain.Offer;
import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.SweetIDException;
import com.onlinesweetshopapi.repository.CategoryRepository;
import com.onlinesweetshopapi.repository.OfferRepository;
import com.onlinesweetshopapi.repository.SweetRepository;
import com.onlinesweetshopapi.service.SweetService;

@Service
public class SweetServiceImpl implements SweetService {

	@Autowired
	private SweetRepository sweetRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public Sweet save(Sweet sweet){
		// TODO Auto-generated method stub
		sweet.setSweetIdentifier(sweet.getSweetIdentifier().toUpperCase()); 
		try { 
			String categoryIdentifier = sweet.getCategoryIdentifier();
			String offerIdentifier = sweet.getOfferIdentifier();
			Category category = categoryRepository.findByCategoryIdentifier(categoryIdentifier);
			Offer offer = offerRepository.findByOfferId(offerIdentifier);
			double price = sweet.getPrice();
			double discount = offer.getOfferDiscount();
			double discountPrice = (discount/100)*price;
			double netPrice = price- discountPrice;
			sweet.setNetPrice(netPrice);
			sweet.setCategory(category);
			sweet.setOffer(offer);
			
			return sweetRepository.save(sweet); 
		}
		catch(Exception e)
		{
			throw new SweetIDException("Sweet"+ sweet.getSweetIdentifier() + " cannot be entered.");
			
		}
	}

	@Override
	public Iterable<Sweet> getSweets() {
		// TODO Auto-generated method stub
		return sweetRepository.findAll();
	}

	@Override
	public Sweet findSweetBySweetIdentifier(String sweetIdentifier) {
		// TODO Auto-generated method stub
		Sweet sweet = sweetRepository.findBySweetIdentifier(sweetIdentifier);
		return sweet;
	}

	@Override
	public void deleteSweetBySweetIdentifier(String sweetIdentifier) {
		// TODO Auto-generated method stub
		Sweet sweet = sweetRepository.findBySweetIdentifier(sweetIdentifier.toUpperCase());
		if(sweet==null)
		{
			throw new SweetIDException(sweetIdentifier +" This sweet does not exist");
		}
		sweetRepository.delete(sweet);
		
	}


	

}
