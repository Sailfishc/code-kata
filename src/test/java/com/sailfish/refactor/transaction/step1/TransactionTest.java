package com.sailfish.refactor.transaction.step1;

import org.junit.Test;

import javax.transaction.InvalidTransactionException;

import static org.junit.Assert.assertTrue;

public class TransactionTest {

    @Test
    public void execute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId.toString(), 30.9);
        boolean result = transaction.execute();
        assertTrue(result);
    }


}