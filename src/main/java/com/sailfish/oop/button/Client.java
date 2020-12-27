/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.oop.button;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2020年12月26日 8:50 下午 chengyi Exp $
 */
public class Client {

        public static void main(String[] args) {
                KeyBoard keyBoard = new KeyBoard();
                keyBoard.press('1');
                keyBoard.press('2');
                keyBoard.press('a');
        }
}