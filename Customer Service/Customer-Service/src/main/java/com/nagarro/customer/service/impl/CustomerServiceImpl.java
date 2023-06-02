package com.nagarro.customer.service.impl;

import com.account.management.entities.Account;
import com.nagarro.customer.service.entities.Customer;
import com.nagarro.customer.service.exceptions.ResourceNotFoundException;
import com.nagarro.customer.service.repositories.CustomerRepository;
import com.nagarro.customer.service.services.CustomerService;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hibernate.annotations.common.util.impl.LoggerFactory.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //private SchemaBindings modelMapper;
    //private String userId;
    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Customer saveCustomer(Customer customer) {
        //generate  unique userId
        String randomUserId = UUID.randomUUID().toString();
        customer.setUserId(randomUserId);
        return customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(String userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Customer with" +
                "given user id is not found on server!!" + userId));
        //fetch account of above customer from account management service
        ArrayList<Account> useraccount =restTemplate.getForObject("http://ACCOUNT-MANAGEMENT-SERVICE/accounts/customer/"+customer.getUserId(), ArrayList.class);
        logger.info("{}",useraccount);
        customer.setAccounts(useraccount);
        return customer;
        //+customer.getUserId()
    }


    //delete
    public void deleteCustomer(String userId) {

        Customer customer = this.customerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Customer", "user id", userId));
        this.customerRepository.delete(customer);


    }
    //update

    public Customer updateCustomer(String userId, Customer customer) {
        Customer existingCustomer = getCustomer(userId);
        existingCustomer.setName(customer.getName());
        existingCustomer.setAccNo(customer.getAccNo());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());

        return customerRepository.save(existingCustomer);
    }

}


        //update
//    @Override
//    public Customer updateCustomer(String customer) {
//
//
//        Customer existingcustomer = customerRepository.findById(UserId()).orElseThrow(() -> new ResourceNotFoundException("Customer", "user id", userId));
//
//
//
//        customer.setName(customer.getName());
//        customer.setEmail(customer.getEmail());
//        customer.setAccNo(customer.getAccNo());
//        customer.setPhone(customer.getPhone());
//        Customer updatedCustomer = this.customerRepository.save(customer);
//        return customerRepository.save(existingcustomer);


///

//    private String User

