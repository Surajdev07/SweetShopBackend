package com.onlinesweetshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
}
