package com.onlinesweetshopapi.web;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.SweetIDException;
import com.onlinesweetshopapi.service.SweetService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/sweets")
public class SweetContoller {
	
	@Autowired
	private SweetService sweetService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
		
	@GetMapping("/list")
	public Iterable<Sweet> getSweets(){
		return sweetService.getSweets();
	}

	@PostMapping("/add")
	public ResponseEntity<?> createSweet(@Valid @RequestBody Sweet sweet, BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		
		Sweet sweet2 = sweetService.save(sweet);
		return new ResponseEntity<Sweet>(sweet2, HttpStatus.CREATED);
	}
	
	@GetMapping("/{sweetIdentifier}")
	public ResponseEntity<?> getSweetBySweetIdentifier(@PathVariable String sweetIdentifier){
		
		Sweet sweet= sweetService.findSweetBySweetIdentifier(sweetIdentifier);
		if(sweet==null) {
			throw new SweetIDException("Sweet Identifier " +sweetIdentifier.toUpperCase()+" does not exist"); 
		}
		return new ResponseEntity<Sweet>(sweet,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{sweetIdentifier}")
	public ResponseEntity<?> deleteSweet(@PathVariable String sweetIdentifier){
		sweetService.deleteSweetBySweetIdentifier(sweetIdentifier);
		return new ResponseEntity<String>(sweetIdentifier.toUpperCase()+" deleted sucessfully",HttpStatus.OK);
	}
	

}
