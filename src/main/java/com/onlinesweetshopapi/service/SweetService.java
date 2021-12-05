 package com.onlinesweetshopapi.service; 


import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.SweetIDException;

public interface SweetService {

	public Sweet save(Sweet sweet);
	public Iterable<Sweet> getSweets();
	public void deleteSweetBySweetIdentifier(String sweetIdentifier);
	public Sweet findSweetBySweetIdentifier(String sweetIdentifier);
}
