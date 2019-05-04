package br.com.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerceapi.entity.Provider;
import br.com.ecommerceapi.service.ProviderService;

@RestController
@RequestMapping("/v1")
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping(path = "/provider", method = RequestMethod.GET)
	@CrossOrigin
	public List<Provider> select() throws Exception {

		return providerService.select();

	}

	@RequestMapping(path = "/provider", method = RequestMethod.POST)
	@CrossOrigin
	public void insert(@RequestBody Provider provider) throws Exception {

		providerService.insert(provider);

	}

	@RequestMapping(path = "/provider", method = RequestMethod.PUT)
	@CrossOrigin
	public void update(@RequestBody Provider provider) throws Exception {

		providerService.update(provider);

	}

	@RequestMapping(path = "/provider", method = RequestMethod.DELETE)
	@CrossOrigin
	public void delete(@RequestParam("id") Integer id) throws Exception {

		providerService.delete(id);

	}

}
