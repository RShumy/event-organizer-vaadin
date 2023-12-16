package com.eventorganizr.organizr;

import com.eventorganizr.organizr.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrganizrApplicationTests {


	@Test
	public void BCryptTest(){
		String password = "Hello_Passowrd_String";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String testPasswordEncoded = passwordEncoder.encode(password);
		System.out.println("encoded password = "+testPasswordEncoded);
		boolean matched = passwordEncoder.matches("Hello_Passowrd_String",testPasswordEncoded);
		assertTrue(matched);
	}






}
