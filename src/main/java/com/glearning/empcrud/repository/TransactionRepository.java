package com.glearning.empcrud.repository;

import com.glearning.empcrud.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}