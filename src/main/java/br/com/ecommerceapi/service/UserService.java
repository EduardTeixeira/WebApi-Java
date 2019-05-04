package br.com.ecommerceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dao.UserDao;
import br.com.ecommerceapi.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public String select() {
		return "Spring boot funcionando !!!";
	}

	public void insert(User user) throws Exception {

		userDao.insert(user);

	}

	public void update(User user) throws Exception {

		userDao.update(user);

	}

	public void delete(Integer id) throws Exception {

		userDao.delete(id);
		
	}

}
