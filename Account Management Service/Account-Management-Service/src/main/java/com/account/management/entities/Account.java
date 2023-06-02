package com.account.management.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="accounts")
public class Account {


    @Column(name = "USERID")
    private String userId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "BALANCE")
    private Double balance;





}

