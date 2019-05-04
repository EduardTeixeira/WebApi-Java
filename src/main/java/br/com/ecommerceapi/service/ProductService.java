package br.com.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerceapi.dao.ProductDao;
import br.com.ecommerceapi.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<Product> select() throws Exception {

		return productDao.select();

	}

	public void insert(Product product) throws Exception{
		
		productDao.insert(product);
		
	}

	public void update(Product product) throws Exception{
		
		productDao.update(product);
		
	}

	public void delete(Integer id) throws Exception{
		
		productDao.delete(id);
	}

}
