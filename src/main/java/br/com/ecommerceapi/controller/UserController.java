package br.com.ecommerceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.entity.User;
import br.com.ecommerceapi.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	@CrossOrigin
	public String select() throws Exception {
		return "Spring boot funcionando !!!";
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	@CrossOrigin
	public void insert(@RequestBody User user) throws Exception {

		userService.insert(user);

	}

	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	@CrossOrigin
	public void update(@RequestBody User user) throws Exception {

		userService.update(user);

	}

	@RequestMapping(path = "/user", method = RequestMethod.DELETE)
	@CrossOrigin
	public void delete(@RequestParam("id") Integer id) throws Exception {

		userService.delete(id);

	}

}