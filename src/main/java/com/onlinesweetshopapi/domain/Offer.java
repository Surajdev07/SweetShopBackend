package com.onlinesweetshopapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="offerId is required")
	@Column(unique = true,updatable = false)
	@Size(min = 4, max = 6 , message ="Size must be between 4 to 6 characters")
	private String offerId;
	@NotBlank(message="offerName is required")
	private String offerName;
	private double offerDiscount;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "offer")
	private List<Sweet> sweets= new ArrayList<Sweet>();
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public double getOfferDiscount() {
		return offerDiscount;
	}
	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}
	public List<Sweet> getSweets() {
		return sweets;
	}
	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}
}
