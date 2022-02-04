package com.sha.transaction.model.service;

import com.sha.transaction.model.entity.Transaction;
import com.sha.transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction, Integer>
{
    @Autowired //nesnesi yoksa oluşturuyor
    protected TransactionRepository transactionRepository;

    public abstract List<Transaction>findAllTransactionOfUser(Integer userID);

}
