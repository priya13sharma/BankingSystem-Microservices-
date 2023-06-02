package com.account.management.controllers;

import com.account.management.entities.Account;

import com.account.management.entities.AccountRequest;
import com.account.management.exceptions.AccountNotFoundException;
import com.account.management.exceptions.CustomerNotFoundException;
import com.account.management.exceptions.InsufficientBalanceException;
import com.account.management.payload.ApiResponse;
import com.account.management.repositories.AccountRepository;
import com.account.management.services.AccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {


    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;


    //account details
    //create
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account account1 = accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account1);

    }

    //single account get
    @GetMapping("/{userId}")
    public ResponseEntity<Account> getSingleAccount(@PathVariable String userId) {
        Account account = accountService.getAccount(userId);
        return ResponseEntity.ok(account);

    }

    //get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> allAccount = accountService.getAllAccount();
        return ResponseEntity.ok(allAccount);

    }

    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteAccount(@PathVariable String userId) {
        this.accountService.deleteAccount(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Account deleted successfully", true, HttpStatus.OK),
                HttpStatus.OK);
    }

    //................................
    @PostMapping("/{userId}/add-money")
    public ResponseEntity<Account> addMoneyToAccount(@RequestBody AccountRequest accountRequest) {

        Account account = accountRepository.findByCustomerId(accountRequest.getCustomerId());
        account.setBalance(account.getBalance() + accountRequest.getBalance());
        Account updatedAccount = accountRepository.save(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }


    @PutMapping("/{userId}/withdraw")
    public ResponseEntity<Account> withdraw(@RequestBody AccountRequest accountRequest) {

        Account account = accountRepository.findByCustomerId(accountRequest.getCustomerId());
        account.setBalance(account.getBalance() - accountRequest.getBalance());
        Account updatedAccount = accountRepository.save(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    //..........
}












//        @Autowired
//        private RestTemplate restTemplate;
//
//        t.getBalance();// API to add money to account
//            @PostMapping("/{accountNumber}/add-money")
//            public ResponseEntity<Account> addMoneyToAccount(@PathVariable String accountNumber, @RequestBody Transaction transaction) {
//                Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
//                if (account == null) {
//                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//                }
//
//                // validate customer details before adding money
//                ResponseEntity<CustomerResponse> response = restTemplate.postForEntity("http://customer-service/customer/validate", account.getCustomer(), CustomerResponse.class);
//                if (response.getStatusCode() != HttpStatus.OK || !response.getBody().isValid()) {
//                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//                }
//
//                // add money to account
//                Double Balance = accoun
//            Balance += transaction.getBalance();
//            account.setBalance(currentBalance);
//            accountRepository.save(account);
//
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        }
//
//        // API to withdraw money from account
//        @PostMapping("/{accountNumber}/withdraw-money")
//        public ResponseEntity<Account> withdrawMoneyFromAccount(@PathVariable Long accountNumber, @RequestBody Transaction transaction) {
//            Account account = accountRepository.findByAccountNumber(accountNumber);
//            if (account == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            // validate customer details before withdrawing money
//            ResponseEntity<CustomerResponse> response = restTemplate.postForEntity("http://customer-service/customers/validate", account.getCustomer(), CustomerResponse.class);
//            if (response.getStatusCode() != HttpStatus.OK || !response.getBody().isValid()) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//
//            // check if account has sufficient balance
//            Double currentBalance = account.getBalance();
//            if (currentBalance < transaction.getAmount()) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//
//            // withdraw money from account
//            currentBalance -= transaction.getAmount();
//            account.setBalance(currentBalance);
//            accountRepository.save(account);
//
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        }
//
//        // API to get account details
//        @GetMapping("/{accountNumber}")
//        public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable Long accountNumber) {
//            Account account = accountRepository.findByAccountNumber(accountNumber);
//            if (account == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            // validate customer details before returning account details
//            ResponseEntity<CustomerResponse> response = restTemplate.postForEntity("http://customer-service/customers/validate", account.getCustomer(), CustomerResponse.class);
//            if (response.getStatusCode() != HttpStatus.OK || !response.getBody().isValid()) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//
//            // prepare account details response
//            AccountDetails accountDetails = new AccountDetails(account, response.getBody().getCustomer());
//            return new ResponseEntity<>(accountDetails, HttpStatus.OK);
//        }
//
//        // API to delete account
//        @DeleteMapping("/{accountNumber}")
//        public ResponseEntity<Void> deleteAccount(@PathVariable Long accountNumber) {
//            Account account = accountRepository.findByAccountNumber(accountNumber);
//            if (account == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            // validate customer details before deleting account
//            ResponseEntity<CustomerResponse> response = restTemplate.postForEntity("http://customer-service/customers/validate", account.getCustomer(), CustomerResponse.class);
//            if (response.getStatusCode() != HttpStatus.OK || !response.getBody().isValid()) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//
//            accountRepository.delete(account);
//            return
