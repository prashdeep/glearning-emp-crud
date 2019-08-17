package com.glearning.empcrud.service;

import com.glearning.empcrud.model.Customer;
import com.glearning.empcrud.repository.CustomerRepository;
import com.glearning.empcrud.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired

    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void doTransaction(Customer fromCustomer, Customer toCustomer, double amount) {
        this.transactionRepository.save(null);

    }
}