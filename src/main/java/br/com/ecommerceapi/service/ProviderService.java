package br.com.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dao.ProviderDao;
import br.com.ecommerceapi.entity.Provider;

@Service
public class ProviderService {

	@Autowired
	private ProviderDao providerDao;

	public List<Provider> select() throws Exception {

		return providerDao.select();

	}

	public void insert(Provider provider) throws Exception {

		providerDao.insert(provider);

	}

	public void update(Provider provider) throws Exception {

		providerDao.update(provider);

	}

	public void delete(Integer id) throws Exception {

		providerDao.delete(id);
		
	}

}
