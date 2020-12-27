/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.oop.button;

/**
 * @author chengyi
 * @version : SendButton.java, v 0.1 2020年12月26日 8:49 下午 chengyi Exp $
 */
public class SendButton implements Button {

    public SendButton() {

    }

    @Override
    public void press() {
        System.out.println("连接无线网");
        System.out.println("正在拨号");
    }
}