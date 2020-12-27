/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.oop.button;

/**
 * @author chengyi
 * @version : KeyBoard.java, v 0.1 2020年12月27日 4:35 下午 chengyi Exp $
 */
public class KeyBoard {

    public void press(char ch) {
        ButtonFactory.getButton(ch).press();
    }

}