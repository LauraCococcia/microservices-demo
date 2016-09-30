package io.pivotal.microservices.services.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.pivotal.microservices.items.Item;

@Service
public class WebItemsService {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebItemsService.class.getName());

	public WebItemsService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
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
		logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory());
	}

	/**
	 * Json delle categorie
	 * 
	 * @return
	 */
	public List<Item> findAll() {
		Item[] items = null;
		try {
			items = restTemplate.getForObject(serviceUrl + "/item", Item[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (items == null || items.length == 0)
			return null;
		else
			return Arrays.asList(items);
	}

	public List<Item> findItemByCategory(String category_id) {
		Item[] items = null;
		try {
			items = restTemplate.getForObject(serviceUrl + "/item/category/" + category_id, Item[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (items == null || items.length == 0)
			return null;
		else
			return Arrays.asList(items);
	}

	public List<Item> findFirst9ByOrderByItemIdAsc() {
		Item[] items = null;

		try {
			items = restTemplate.getForObject(serviceUrl + "/item/home", Item[].class);
		} catch (RestClientException e) {
			logger.info(serviceUrl + "/item/home");
			e.printStackTrace();
		}
		if (items == null || items.length == 0)
			return null;
		else
			return Arrays.asList(items);
	}
}
