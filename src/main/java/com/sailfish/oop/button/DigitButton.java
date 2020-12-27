/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.oop.button;

/**
 * @author chengyi
 * @version : DigitButton.java, v 0.1 2020年12月26日 8:42 下午 chengyi Exp $
 */
public class DigitButton implements Button {

    /**
     * 输入的数字`
     */
    private int digit;

    public DigitButton(int digit) {
        this.digit = digit;
    }

    @Override
    public void press() {
        System.out.println("显示数字:" + digit);
        System.out.println("播报声音:" + digit);
    }
}