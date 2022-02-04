package com.sha.transaction.model.repository;

import com.sha.transaction.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    //select * from transactions where user_id = ?

    //interface olduğu için erişim belirleyicisi zaten public'tir
    List<Transaction> findAllByUserID(Integer userID);
}
