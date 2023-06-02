package com.nagarro.customer.service.controllers;
import com.nagarro.customer.service.entities.Customer;
import com.nagarro.customer.service.payload.ApiResponse;
import com.nagarro.customer.service.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //create
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer1);

    }

    //single customer get
    @GetMapping("/{userId}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable String userId) {
        Customer customer = customerService.getCustomer(userId);
        return ResponseEntity.ok(customer);

    }

    //get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);

    }
    //delete
    @DeleteMapping("/{userId}")
public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
 this.customerService.deleteCustomer(userId);
return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true, HttpStatus.OK),
        HttpStatus.OK);
    }
    //update
    @PutMapping("/{userId}")
    public Customer updateCustomer(@PathVariable String userId, @RequestBody Customer customer) {
        return customerService.updateCustomer(userId, customer);
    }
    }


