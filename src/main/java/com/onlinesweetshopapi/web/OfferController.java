package com.onlinesweetshopapi.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinesweetshopapi.domain.Offer;
import com.onlinesweetshopapi.exception.AdminIDException;
import com.onlinesweetshopapi.service.OfferService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
	Logger logger = LoggerFactory.getLogger(OfferController.class);
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;


	@PostMapping("/add")
	public ResponseEntity<?> createOffer(@Validated @RequestBody Offer offer, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Offer createdOffer= offerService.saveOrUpdate(offer);
		return new ResponseEntity<Offer>(createdOffer, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{offerId}")
	public ResponseEntity<Offer> getOfferByOfferId(@PathVariable String offerId) {
		Offer offer = offerService.findOfferByOfferId(offerId);
		if(offer==null)
		{
			throw new AdminIDException("AdminId "+offerId.toUpperCase() +" does not exist");
		}
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Offer> getAllOffers(){
		return offerService.findAllOffers();
	}
	
	@DeleteMapping("/{offerId}")
	public ResponseEntity<?> deleteOffer(@PathVariable String offerId){
		offerService.deleteOfferByOfferId(offerId);
		return new ResponseEntity<String>("Offer With id : "+offerId.toUpperCase()+" is deleted successfully",HttpStatus.OK);
	}
}
