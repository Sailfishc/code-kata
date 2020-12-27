/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.reflect;

/**
 * @author chengyi
 * @version : ReflectDemo.java, v 0.1 2020年12月27日 6:07 下午 chengyi Exp $
 */
public class ReflectDemo {

    public static void main(String[] args) {
        UserService userService = new UserServiceProxy(new UserServiceImpl()).getProxy();
        userService.say();
    }
}