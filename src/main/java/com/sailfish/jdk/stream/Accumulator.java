/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.jdk.stream;

/**
 * @author chengyi
 * @version : Accumulator.java, v 0.1 2021年02月18日 10:51 下午 chengyi Exp $
 */
public class Accumulator {

    public long total = 0;

    public void add(long value) {
        total += value;
    }

}