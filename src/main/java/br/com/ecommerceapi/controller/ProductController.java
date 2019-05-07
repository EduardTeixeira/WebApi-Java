package br.com.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.entity.Product;
import br.com.ecommerceapi.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/product", method = RequestMethod.GET)
	@CrossOrigin
	public List<Product> select() throws Exception {

		return productService.select();

	}

	@RequestMapping(path = "/product", method = RequestMethod.POST)
	@CrossOrigin
	public void insert(@RequestBody Product product) throws Exception {

		productService.insert(product);

	}

	@RequestMapping(path = "/product", method = RequestMethod.PUT)
	@CrossOrigin
	public void update(@RequestBody Product product) throws Exception {

		productService.update(product);

	}

	@RequestMapping(path = "/product", method = RequestMethod.DELETE)
	@CrossOrigin
	public void delete(@RequestParam("id") Integer id) throws Exception {

		productService.delete(id);

	}

}
