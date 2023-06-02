package com.nagarro.customer.service.external.services;

import com.account.management.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name="ACCOUNT-MANAGEMENT-SERVICE")
public interface AccountManagementService {
    @GetMapping("/accounts/{userId}")
    Account getAccount(@PathVariable("userId") String userId);
//   ..............




    }
