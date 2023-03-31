package com.client.webfluxtest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.webfluxtest.service.WebFluxService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/service")
public class TestController {

	@Autowired
	WebFluxService webFluxService;

	@GetMapping("/test")
	public String test() {
		return "Hello";
	}

	@GetMapping("/getMono")
	public Mono<Map<String, Object>> getMono() {
		
		return webFluxService.getMonoMapObject();

	}

}
