package com.account.management.entities;


    public class AccountRequest {

        private String customerId;
        private double balance;

        public AccountRequest() {}

        public AccountRequest(String customerId, double balance) {
            this.customerId = customerId;
            this.balance = balance;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }


    }


