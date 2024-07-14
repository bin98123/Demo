package com.flawlessdefense.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashingPassword {

	public String hashing(String input) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		String a = passwordEncoder.encode(input);
		return a;
	}
}
