package com.example.customer;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tesobe.obp.AbstractTestSupport;
import com.example.model.customer.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest extends AbstractTestSupport {
	
	@Autowired
	private CustomerService customerService; 

	@Test
    public void testGetCustomers()
    {
		List<Customer> customerList = customerService.getCustomers(authToken, "bnpp.12.fr.fr");
		System.out.println("Customer Size :" + customerList.size());
    }
	
	
}
