/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step1;

/**
 * @author chengyi
 * @version : RedisDistributedLock.java, v 0.1 2021年03月21日 5:38 下午 chengyi Exp $
 */
public class RedisDistributedLock implements Lock {


    @Override
    public boolean lock(String key) {
        return false;
    }

    @Override
    public void unLock() {

    }
}