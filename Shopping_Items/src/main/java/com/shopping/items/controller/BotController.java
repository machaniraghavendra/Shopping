package com.shopping.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.items.entity.Bot;
import com.shopping.items.service.BotServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bot/")
public class BotController {

	@Autowired
	BotServiceImpl botServiceImpl;

	@PostMapping("/")
	public void getResponse(@RequestBody Bot bot) {
		botServiceImpl.queryReponse(bot);
	}

	@GetMapping("/")
	public ResponseEntity<List<Bot>> viewAllResponse() {
		return ResponseEntity.ok(botServiceImpl.viewAllResponse());
	}

	@PostMapping("/{email}")
	public void listClear(@PathVariable String email) {
		botServiceImpl.listClear(email);
	}
}
