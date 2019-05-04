package br.com.ecommerceapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/v1/test")
public class TestController {

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	@CrossOrigin
	public String index() {
		return "API Response - OK !";
	}

}
