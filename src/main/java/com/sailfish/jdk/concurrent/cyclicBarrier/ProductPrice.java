/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.cyclicBarrier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chengyi
 * @version : ProductPrice.java, v 0.1 2020年12月13日 7:46 下午 chengyi Exp $
 */
@ToString
@Getter
@Setter
public class ProductPrice {

    private final int productId;
    private double price;

    public ProductPrice(int productId) {
        this.productId = productId;
    }

    public ProductPrice(int productId, double price) {
        this.productId = productId;
        this.price = price;
    }

}