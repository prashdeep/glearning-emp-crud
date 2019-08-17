package com.glearning.empcrud.service;


import com.glearning.empcrud.model.Customer;

public interface CustomerService {

    void doTransaction(Customer fromCustomer, Customer toCustomer, double amount);
}