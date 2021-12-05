package com.onlinesweetshopapi.service;

import com.onlinesweetshopapi.domain.Admin;
import com.onlinesweetshopapi.exception.AdminIDException;

public interface AdminService {

	public Admin saveOrUpdate(Admin admin) throws AdminIDException;

	public Admin findAdminByUserId(String userId);
	public Admin updateByUserId(String userId , int isloggedIn );

}
