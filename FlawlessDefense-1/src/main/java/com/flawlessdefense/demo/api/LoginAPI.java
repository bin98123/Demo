package com.flawlessdefense.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.MessageDigest;

import com.flawlessdefense.demo.dto.UserDTO;
import com.flawlessdefense.demo.service.HashingPassword;

@Controller
public class LoginAPI {
//	@Autowired
//	UserDTO userDTO;
	@Autowired
	HashingPassword hashingPassword;

	@GetMapping(value = "/login/check", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDTO login(@RequestParam(value = "name") String name) {
//		return "./pages/home";
//		if (name == null) {
//			return (ResponseEntity<Object>) ResponseEntity.status(400);
//		}
		String passwordOld = "abcd";
		String passwordDB = hashingPassword.hashing(passwordOld);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

		return new UserDTO("" + (passwordEncoder.matches(name, passwordDB)));

	}

	@GetMapping(value = "/login/check-pass", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDTO login1(@RequestParam(value = "name") String name) {
//		return "./pages/home";
//		if (name == null) {
//			return (ResponseEntity<Object>) ResponseEntity.status(400);
//		}
		String passwordOld = "abcd";
		String passwordDB = hashingPassword.hashing(passwordOld);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

		return new UserDTO(name);

	}

	@GetMapping(value = "/login")
	public String login() {
		return "./pages/home";

	}
}
