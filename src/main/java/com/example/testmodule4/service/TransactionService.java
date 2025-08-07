package com.example.testmodule4.service;

import com.example.testmodule4.model.Customer;
import com.example.testmodule4.model.Transaction;
import com.example.testmodule4.repository.CustomerRepository;
import com.example.testmodule4.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void delete(String id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> search(String name, String type) {
        return transactionRepository.search(name, type);
    }


    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}


