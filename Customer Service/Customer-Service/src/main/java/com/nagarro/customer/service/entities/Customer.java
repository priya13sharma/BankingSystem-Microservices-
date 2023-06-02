package com.nagarro.customer.service.entities;
import com.account.management.entities.Account;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {

    @Id

        @Column(name = "ID")
        private String UserId;
        @Column(name = "NAME")
        private String name;
        @Column(name = "AccNo")
        private String accNo;
        @Column(name = "EMAIL")
        private String email;
        @Column(name = "PHONE")
        private String phone;
        @Transient
        private List<Account> accounts= new ArrayList<>();


}

