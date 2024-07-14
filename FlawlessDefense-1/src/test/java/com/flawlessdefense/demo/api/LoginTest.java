package com.flawlessdefense.demo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenJsonConverterIsFound_thenReturnResponse() throws Exception {
		String url = "/login/check-pass?name=HA";
		
		String salt = "abcd";
		PasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder(10);
		String a = passwordEncoder1.encode("abcd" + salt);

		this.mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(content().json("{'name':'HA'}"));
		this.mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(content().json("{'name':'HA'}"));
	}
}
