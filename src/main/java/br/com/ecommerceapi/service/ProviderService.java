package br.com.ecommerceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dao.ProviderDao;

@Service
public class ProviderService {

	@Autowired
	private ProviderDao providerDao;

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
