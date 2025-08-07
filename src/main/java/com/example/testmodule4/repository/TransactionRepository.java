package com.example.testmodule4.repository;

import com.example.testmodule4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT t FROM Transaction t " +
            "WHERE (:name IS NULL OR LOWER(t.customer.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:type IS NULL OR t.serviceType = :type)")
    List<Transaction> search(@Param("name") String name, @Param("type") String type);


}
