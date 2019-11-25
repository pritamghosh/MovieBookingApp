package com.pritam.idm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMangementController {


	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}


}
