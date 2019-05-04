package br.com.ecommerceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/select", method = RequestMethod.GET)
	@CrossOrigin
	public String select() {
		return "Spring boot funcionando !!!";
	}

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	@CrossOrigin
	public String insert() {
		return "Spring boot funcionando !!!";
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	@CrossOrigin
	public String update() {
		return "Spring boot funcionando !!!";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	@CrossOrigin
	public String delete() {
		return "Spring boot funcionando !!!";
	}

}