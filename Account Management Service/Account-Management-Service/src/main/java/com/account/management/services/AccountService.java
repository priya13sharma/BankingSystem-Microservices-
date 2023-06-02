package com.account.management.services;
import com.account.management.entities.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {

  //  .........................
    //create
    Account saveAccount(Account account);



    List<Account> getAllAccount();
    //get account details with acc no
    Account getAccount(String userId);

    void deleteAccount(String userId);
    //ADD
    boolean addMoneyToAccount(String customerId, double balance);

  //BOOLEAN
  boolean withdraw(String customerId, String accountNumber, double balance) throws AccountNotFoundException;

  //     account.setBalance(account.getBalance() - balance);
  //     accountRepository.save(account);
  // }
  boolean withdraw(String customerId, double balance);


  //        private boolean validateCustomer(String customerId) {
  //            try {
  //                Customer customer = customerClient.getCustomer(customerId);
  //                return customer != null;
  //            } catch (Exception e) {
  //                return false;
  //            }
      //..............................



  // delete account
   // void deleteAccount(String userId);
}



    //private final String customerServiceUrl = "http://customer-service/customers/{customerId}";



//ADD MONEY
//        public Account addMoneyToAccount(String userId, String accountNumber, double balance) {
//            // Check if customer is valid
//            String customerServiceUrl = "http://customer-service/customer/" + userId;
//            //ResponseEntity<Customer> customerResponse = restTemplate.getForEntity(customerServiceUrl, Customer.class);
//            if (customerResponse.getStatusCodeValue() == HttpStatus.NOT_FOUND.value()) {
//                throw new IllegalArgumentException("Customer with ID " + userId + " not found");
//            }
//
//            // Check if account is valid
//            Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
//            if (!optionalAccount.isPresent()) {
//                throw new IllegalArgumentException("Account with account number " + accountNumber + " not found");
//            }
//            Account account = optionalAccount.get();
//
//            // Add money to account
//            account.setBalance(account.getBalance() + balance);
//            Account updatedAccount = accountRepository.save(account);
//
//            return updatedAccount;
//        }
//




