package br.com.ecommerceapi.controller;

import java.util.List;

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
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	@CrossOrigin
	public User login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		
		return userService.login(username, password);
		
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	@CrossOrigin
	public List<User> select() throws Exception {
		
		return userService.select();
		
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