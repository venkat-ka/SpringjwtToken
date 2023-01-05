package com.app.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	 @GetMapping("/chec")
	 public ResponseEntity<String> myCheck(){
		 return ResponseEntity.ok("Hi JwtTokn");
	 }
}
