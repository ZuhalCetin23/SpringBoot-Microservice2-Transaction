package com.sha.transaction.model.service;

import com.sha.transaction.model.entity.Transaction;
import com.sha.transaction.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractTransactionService
{
    @Override
    public List<Transaction> findAllTransactionOfUser(Integer userID) {

        return transactionRepository.findAllByUserID(userID);
    }

    @Override
    public List<Transaction> findAll() {

        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction entity) {
        try
        {
            return transactionRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return new Transaction();
        }

    }

    @Override
    public void deleteByID(Integer id) {
        try
        {
            transactionRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
        }
    }

}
