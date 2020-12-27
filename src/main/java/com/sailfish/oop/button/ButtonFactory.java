/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.oop.button;

/**
 * @author chengyi
 * @version : ButtonFactory.java, v 0.1 2020年12月27日 4:48 下午 chengyi Exp $
 */
public class ButtonFactory {

    /**
     * 获取Button
     * @param ch
     * @return
     */
    public static Button getButton(char ch) {
        if (Character.isDigit(ch)) {
            // 是数字
            return new DigitButton(Integer.parseInt(String.valueOf(ch)));
        } else {
            // 发送按钮
            return new SendButton();
        }
    }
}