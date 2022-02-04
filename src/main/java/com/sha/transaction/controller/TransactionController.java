package com.sha.transaction.controller;

import com.sha.transaction.model.entity.Transaction;
import com.sha.transaction.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {

    @Autowired
    private AbstractTransactionService transactionService;

    // api/product
    @GetMapping("{userID}")
    public ResponseEntity<List<Transaction>> getTransactionOfUser(@PathVariable Integer userID)
    {
        return ResponseEntity.ok(transactionService.findAllTransactionOfUser(userID));
    }

    //api/transaction/transactionID
    @DeleteMapping("{transactionID}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable Integer transactionID)
    {
        transactionService.deleteByID(transactionID);

        return new ResponseEntity(HttpStatus.OK);
    }

    // api/transaction
    @PostMapping
    public ResponseEntity<Transaction> saveProduct(@RequestBody Transaction transaction)
    {
        Transaction savedTransaction = transactionService.save(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // api/transaction
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransaction()
    {

        return ResponseEntity.ok(transactionService.findAll());

    }

}
