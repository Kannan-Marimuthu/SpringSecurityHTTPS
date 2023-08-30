package com.kannan.exam;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kannan.exam.dto.User;

@RestController
public class MainController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String greet() {
		return "Kannan";
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsers(@PathVariable(value = "id") Long userId) {
		HashMap<String, Long> params = new HashMap<>();
		params.put("id", userId);
		return restTemplate.getForEntity("http://localhost:1234/api/v1/users/{id}", User.class, params);
	}

	@GetMapping("/users")
	public User[] getUsers() {
		return restTemplate.getForObject("http://localhost:1234/api/v1/users", User[].class);
	}
}
