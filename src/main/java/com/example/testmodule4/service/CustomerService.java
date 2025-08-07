package com.example.testmodule4.service;

import com.example.testmodule4.model.Customer;
import com.example.testmodule4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}

