package io.pivotal.microservices.services.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.pivotal.microservices.categories.Category;

@Service
public class WebCategoriesService {
	
	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebCategoriesService.class
			.getName());

	public WebCategoriesService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory());
	}

	/**
	 * Json delle categorie
	 * @return
	 */
	public List<Category> findAll(){
		Category[] categories = null;
		try {
			categories = restTemplate.getForObject(serviceUrl
					+ "/category", Category[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (categories == null || categories.length == 0)
			return null;
		else
			return Arrays.asList(categories);
	}
}