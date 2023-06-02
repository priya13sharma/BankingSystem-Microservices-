package com.nagarro.customer.service.services;

import com.nagarro.customer.service.entities.Customer;

import java.util.List;


public interface CustomerService {


    //create


    Customer saveCustomer(Customer customer);

    //get all customers
    List<Customer> getAllCustomer();

    //get single customer with acc no
    Customer getCustomer(String userId);


    // delete
      void deleteCustomer(String userId);

//
    Customer updateCustomer(String userId, Customer customer);
}



