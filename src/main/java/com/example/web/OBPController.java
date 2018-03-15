package com.example.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.CustomerService;
import com.example.model.Client;
import com.example.model.customer.Customer;
import com.example.obp.account.Account;
import com.example.obp.account.AccountService;
import com.example.obp.auth.DirectAuthenticationService;

@RestController
public class OBPController {

	private static final Logger logger = LoggerFactory.getLogger(OBPController.class);

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;

	@Autowired
	private DirectAuthenticationService directAuthenticationService;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	@RequestMapping(value = "/obp/validateClient", method = RequestMethod.POST)
	public ResponseEntity<Client> validateClient(@RequestBody Client client) {

		System.out.println("Hiee" + client);
		logger.info("Hello");

		String authToken = directAuthenticationService.login(username, password);

		List<Account> accountList = accountService.fetchPrivateAccounts(authToken, false);
		checkInputAccountAvailableOrNot(accountList, client);

		List<Customer> customerList = customerService.getCustomers(authToken, client.getBankId());
		checkCustomerAvailableorNot(customerList, client);
        
		//return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		return new ResponseEntity<Client>(client,HttpStatus.OK);

	}

	private void checkInputAccountAvailableOrNot(List<Account> accountList, Client client) {

		for (Account account : accountList) {
			if (account.getId().equalsIgnoreCase(client.getAccountId())) {
				client.setAccountAvailable(true);
				break;
			}
		}

	}

	private void checkCustomerAvailableorNot(List<Customer> customerList, Client client) {

		for (Customer customer : customerList) {

			if (customer.getCustomerNumber().equalsIgnoreCase(client.getCustomerNumber())) {
				client.setCustomerAvailable(true);
				client.setKYCDone(customer.getKycStatus());
				break;
			}
		}

	}
	
	

}
