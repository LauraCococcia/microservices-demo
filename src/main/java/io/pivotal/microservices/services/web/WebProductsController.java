package io.pivotal.microservices.services.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.products.Product;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebProductsService}.
 * 
 * @author Daniele Di Pompeo
 */
@Controller
public class WebProductsController {

	@Autowired
	protected WebProductsService productsService;

	protected Logger logger = Logger.getLogger(WebProductsController.class.getName());

	public WebProductsController(WebProductsService productsService) {
		this.productsService = productsService;
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setAllowedFields("accountNumber", "searchText");
	// }

	// @RequestMapping("/accounts")
	// public String goHome() {
	// return "index";
	// }

	// @RequestMapping("/accounts/{accountNumber}")
	// public String byNumber(Model model,
	// @PathVariable("accountNumber") String accountNumber) {
	//
	// logger.info("web-service byNumber() invoked: " + accountNumber);
	//
	// Account account = accountsService.findByNumber(accountNumber);
	// logger.info("web-service byNumber() found: " + account);
	// model.addAttribute("account", account);
	// return "account";
	// }

	// @RequestMapping("/accounts/owner/{text}")
	// public String ownerSearch(Model model, @PathVariable("text") String name)
	// {
	// logger.info("web-service byOwner() invoked: " + name);
	//
	// List<Account> accounts = accountsService.byOwnerContains(name);
	// logger.info("web-service byOwner() found: " + accounts);
	// model.addAttribute("search", name);
	// if (accounts != null)
	// model.addAttribute("accounts", accounts);
	// return "accounts";
	// }

	// @RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
	// public String searchForm(Model model) {
	// model.addAttribute("searchCriteria", new SearchCriteria());
	// return "accountSearch";
	// }

	// @RequestMapping(value = "/accounts/dosearch")
	// public String doSearch(Model model, SearchCriteria criteria,
	// BindingResult result) {
	// logger.info("web-service search() invoked: " + criteria);
	//
	// criteria.validate(result);
	//
	// if (result.hasErrors())
	// return "accountSearch";
	//
	// String accountNumber = criteria.getAccountNumber();
	// if (StringUtils.hasText(accountNumber)) {
	// return byNumber(model, accountNumber);
	// } else {
	// String searchText = criteria.getSearchText();
	// return ownerSearch(model, searchText);
	// }
	// }

	@RequestMapping(value = "/shop")
	public String getShop(Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Product> products = productsService.findAll();
		model.addAttribute("products", products);
		return "shop";
	}
}
