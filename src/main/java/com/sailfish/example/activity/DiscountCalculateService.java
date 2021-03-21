/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.example.activity;

/**
 * 计算优惠
 *
 * @author chengyi
 * @version : DiscountCalculateService.java, v 0.1 2021年01月07日 4:10 下午 chengyi Exp $
 */
public interface DiscountCalculateService {

    /**
     * 计算优惠利率
     *
     * @param req
     * @return
     */
    DiscountCalculateResult calculateDiscount(DiscountCalculateReq req);

}