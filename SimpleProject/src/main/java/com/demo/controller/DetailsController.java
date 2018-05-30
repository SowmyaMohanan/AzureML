package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.AzureML;
import com.demo.pojo.Customer;

@RestController
@RequestMapping(value = "/admin/*")
public class DetailsController {
	
	@Autowired
	private AzureML azure;
	
	@RequestMapping(value = "/allCustomer", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> fetchCustomers() {
		System.out.println("Start ---- Inside fetchCustomers");
		
		azure.readJson("jsonFile.json");
		List<Customer> customers = azure.rrsHttpPost();
		//System.out.println();

		if (customers.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.OK);
		}
		System.out.println("Start ---- End fetchCustomers");

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
}
