package com.account.management.impl;


import com.account.management.entities.Account;
import com.account.management.exceptions.ResourceNotFoundException;
import com.account.management.repositories.AccountRepository;
import com.account.management.services.AccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;
@Service
public class AccountImpl  implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account saveAccount(Account account) {
        //generate  unique accNo
       String randomAccountNumber= UUID.randomUUID().toString();
        account.setAccountNumber(randomAccountNumber);
        return accountRepository.save(account);
        //generate  unique userId


    }


    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }


    @Override
    public Account getAccount(String userId) {


        return accountRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Customer with" +
                "given acc no is not found on server!!" + userId));
    }

    //delete
    public void deleteAccount(String userId) {

        Account account = this.accountRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Account", "user id", userId));
        this.accountRepository.delete(account);


    }

    //.........................................


    //@Autowired
    //private CustomerClient customerClient;

    @Override
    public boolean addMoneyToAccount(String customerId, double balance) {
        // check if customer exists
//            if (!validateCustomer(customerId)) {
//                return false;
//            }
        // add money to account
        Account account = accountRepository.findByCustomerId(customerId);
        account.setBalance(account.getBalance() + balance);
        accountRepository.save(account);
        return true;
    }

    @Override
    public boolean withdraw(String customerId, String accountNumber, double balance) throws AccountNotFoundException {
        return false;
    }


    //        private boolean validateCustomer(String customerId) {
//            try {
//                Customer customer = customerClient.getCustomer(customerId);
//                return customer != null;
//            } catch (Exception e) {
//                return false;
//            }
    //..............................

        // validate customer using customerClient
//    Customer customer = customerClient.getCustomerById(customerId);
//    if (customer == null) {
//        throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
//    }

        // get account for customer
        // @Transactional
        // public void withdraw(String userId, double balance) throws InsufficientBalanceException {
        //     Account account = accountRepository.findById(userId)
        //             .orElseThrow(() -> new IllegalArgumentException("Invalid account id"));

        //     if (account.getBalance() < balance) {
        //         throw new InsufficientBalanceException();
        //     }

        //     account.setBalance(account.getBalance() - balance);
        //     accountRepository.save(account);
        // }
        @Override
    public boolean withdraw(String customerId, double balance) {
        // check if customer exists
//            if (!validateCustomer(customerId)) {
//                return false;
//            }
        // add money to account
        Account account = accountRepository.findByCustomerId(customerId);
        account.setBalance(account.getBalance() - balance);
        accountRepository.save(account);
        return true;
    }
}



















