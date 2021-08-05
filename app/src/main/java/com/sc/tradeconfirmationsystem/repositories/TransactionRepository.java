package com.sc.tradeconfirmationsystem.repositories;

import com.sc.tradeconfirmationsystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
