package com.onlinesweetshopapi.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.onlinesweetshopapi.domain.Admin;
import com.onlinesweetshopapi.exception.AdminIDException;
import com.onlinesweetshopapi.service.AdminService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =AdminController.class)
class AdminControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private AdminService adminService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	@Test
	void test_getAdminByAdminIdentifier() throws Exception{
		BDDMockito.given(adminService.findAdminByUserId(Mockito.anyString())).willReturn(new Admin("Jat16", "Jatin", "XYZ","jatin@gmail.com"));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admins/ADMIN1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("userId").value("Jat16"));
	}
	
	@Test
	void test_getAdminByAdminIdentifier_ThrowAdminIDException() throws Exception
	{
		BDDMockito.given(adminService.findAdminByUserId(Mockito.anyString())).willThrow(new AdminIDException());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admins/ADMIN2"))
		.andExpect(status().isBadRequest());
	}
	

}
