/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step0;

import javax.transaction.InvalidTransactionException;

import static com.sun.deploy.util.SecurityBaseline.isExpired;

/**
 * @author chengyi
 * @version : Transaction.java, v 0.1 2021年03月21日 5:18 下午 chengyi Exp $
 */
public class Transaction {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;


    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId,
                       String orderId, Double amount) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis(); // ?
        this.amount = amount;
    }

    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException("InvalidTrans");
        }
        if (status == STATUS.EXECUTED)
            return true;
        boolean isLocked = false;
        try {
            isLocked = RedisDistributedLock.getSingletonInstance().lockTransaction(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED)
                return true; // double check
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > 14L * 24 * 3600 * 1000) {
                this.status = STATUS.EXPIRED;
                return false;
            }

            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }

            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
            }
        }
    }

}