package br.com.ecommerceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public String select() {
		return "Spring boot funcionando !!!";
	}

	public String insert() {
		return "Spring boot funcionando !!!";
	}

	public String update() {
		return "Spring boot funcionando !!!";
	}

	public String delete() {
		return "Spring boot funcionando !!!";
	}

}
