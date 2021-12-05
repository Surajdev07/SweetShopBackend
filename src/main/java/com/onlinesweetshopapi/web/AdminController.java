package com.onlinesweetshopapi.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Admin;
import com.onlinesweetshopapi.exception.AdminIDException;
import com.onlinesweetshopapi.service.AdminService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired(required = true)
	private AdminService adminService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping
	public ResponseEntity<?> createAdmin(@Valid @RequestBody Admin admin, BindingResult result)
			throws AdminIDException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Admin createdAdmin = adminService.saveOrUpdate(admin);
		return new ResponseEntity<Admin>(createdAdmin, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Admin> getAdminByUserId(@PathVariable String userId) {
		Admin admin = adminService.findAdminByUserId(userId);
		if(admin==null)
		{
			throw new AdminIDException("AdminId "+userId.toUpperCase() +" does not exist");
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@PatchMapping("/{userId}/{isloggedIn}")
	public ResponseEntity<?> updateAdmin(@Valid @PathVariable String userId,@PathVariable int isloggedIn) {
		adminService.updateByUserId(userId, isloggedIn);
		Admin admin = adminService.findAdminByUserId(userId);
		if(admin==null)
		{
			throw new AdminIDException("AdminId "+userId.toUpperCase() +" does not exist");
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		
	}
}
