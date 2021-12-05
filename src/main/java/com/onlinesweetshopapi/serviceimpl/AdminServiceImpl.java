package com.onlinesweetshopapi.serviceimpl;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinesweetshopapi.domain.Admin;
import com.onlinesweetshopapi.exception.AdminIDException;
import com.onlinesweetshopapi.repository.AdminRepository;
import com.onlinesweetshopapi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveOrUpdate(Admin admin) throws AdminIDException {
		try {
			admin.setUserId(admin.getUserId().toUpperCase());
			return adminRepository.save(admin);
		} catch (Exception ex) {
			throw new AdminIDException("UserId" + admin.getUserId() + "is already available");
		}
	}

	@Override
	public Admin findAdminByUserId(String userId) {
		Admin admin = adminRepository.findByuserId(userId);
//		Admin admin = new Admin();
		return admin;

	}

	@Override
	public Admin updateByUserId(String userId, int isloggedIn) {
	
	Admin admin =	findAdminByUserId(userId);
	admin.setIsloggedIn(isloggedIn);
		return adminRepository.save(admin);
	}
}
