/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.transaction.step1;

/**
 * @author chengyi
 * @version : WalletRpcService.java, v 0.1 2021年03月21日 5:26 下午 chengyi Exp $
 */
public interface WalletRpcService {

    String moveMoney(String id, Long buyerId, Long sellerId, Double amount);
}