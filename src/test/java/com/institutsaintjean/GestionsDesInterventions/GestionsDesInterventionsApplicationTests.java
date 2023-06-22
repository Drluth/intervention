package com.institutsaintjean.GestionsDesInterventions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class GestionsDesInterventionsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void encodeEncryptUserPassword(){
		String password = "1234";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String testPasswordEncoded = passwordEncoder.encode(password);
		System.out.println("encoded password  = "+testPasswordEncoded);


	}

}
