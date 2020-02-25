package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HomeController {
	//http://localhost:2000/demo/check
	@RequestMapping(value="/check", method=RequestMethod.GET)
	public void show()
	{
		System.out.println("Hello");
	}

}
