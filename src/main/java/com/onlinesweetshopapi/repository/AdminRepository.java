package com.onlinesweetshopapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

	Admin findByuserId(String userId);

}
