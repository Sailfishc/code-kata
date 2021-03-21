/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step1;

/**
 * @author chengyi
 * @version : Lock.java, v 0.1 2021年03月21日 5:37 下午 chengyi Exp $
 */
public interface Lock {

    boolean lock(String key);

    void unLock();
}