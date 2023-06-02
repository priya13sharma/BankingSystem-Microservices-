package com.nagarro.customer.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

public class Account {







    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    public class Rating {
        @Id
        private String userId;

        private String accountNumber;

        private String balance;
    }
}
