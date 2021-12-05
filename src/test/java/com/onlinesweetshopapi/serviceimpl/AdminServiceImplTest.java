package com.onlinesweetshopapi.serviceimpl;





import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.onlinesweetshopapi.domain.Admin;
import com.onlinesweetshopapi.repository.AdminRepository;

class AdminServiceImplTest {

	@Mock
	AdminRepository adminRepository;
	
	@InjectMocks
	AdminServiceImpl adminServiceImpl;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test_findAdminByUserId() {
		BDDMockito.given(adminRepository.findByuserId("JAT16")).
		willReturn(new Admin("Jat16", "Jatin", "XYZ","jatin@gmail.com"));
		Admin admin = adminServiceImpl.findAdminByUserId("JAT16");
		assertNotNull(admin);
		assertEquals("Jatin",admin.getName());
	}

}
