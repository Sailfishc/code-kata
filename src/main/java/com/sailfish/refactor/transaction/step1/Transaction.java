/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step1;

import com.sailfish.refactor.transaction.step0.IdGenerator;
import com.sailfish.refactor.transaction.step0.STATUS;
import com.sailfish.refactor.transaction.step0.WalletRpcService;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.InvalidTransactionException;

import static com.sun.deploy.util.SecurityBaseline.isExpired;

/**
 * @author chengyi
 * @version : Transaction.java, v 0.1 2021年03月21日 5:18 下午 chengyi Exp $
 */
@Setter
@Getter
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

    private Lock lock;
    private WalletRpcService walletRpcService;

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId,
                       String orderId, Double amount) {
        this.id = generateId(preAssignedId);
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = getCurrentTimeStamp();
        this.amount = amount;
    }

    private String generateId(String preAssignedId) {
        String id;
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            id = preAssignedId;
        } else {
            id = IdGenerator.generateTransactionId();
        }
        if (id.startsWith("t_")) {
            id = "t_" + preAssignedId;
        }
        return id;
    }


    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException("InvalidTrans");
        }
        if (status == STATUS.EXECUTED) {
            return true;
        }

        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED) {
                return true;
            }
            if (getCurrentTimeStamp() - createTimestamp > getExpireTime()) {
                this.status = STATUS.EXPIRED;
                return false;
            }

            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }

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
                lock.unLock();
            }
        }
    }


    private long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    private long getExpireTime() {
        return 14L * 24 * 3600 * 1000;
    }

}