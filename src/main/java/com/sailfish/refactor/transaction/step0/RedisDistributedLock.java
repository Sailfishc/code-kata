/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step0;

/**
 * @author chengyi
 * @version : RedisDistributedLock.java, v 0.1 2021年03月21日 5:22 下午 chengyi Exp $
 */
public class RedisDistributedLock {
    public static RedisDistributedLock getSingletonInstance() {
        return null;
    }

    public void unlockTransaction(String id) {

    }

    public boolean lockTransaction(String id) {
        return false;
    }
}