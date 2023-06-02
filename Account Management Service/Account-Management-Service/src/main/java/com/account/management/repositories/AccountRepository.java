package com.account.management.repositories;
import com.account.management.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account,String>
{
    Account findByCustomerId(String customerId);

    Account findByAccountNumberAndCustomerId(String accountNumber, String customerId);


    //ptional<Account> findByAccountNumber(String accountNumber);

    //Optional<Account> findById(String Id);
}
