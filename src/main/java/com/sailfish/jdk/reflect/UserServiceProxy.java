/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chengyi
 * @version : UserServiceProxy.java, v 0.1 2020年12月27日 6:13 下午 chengyi Exp $
 */
public class UserServiceProxy implements InvocationHandler {

    private Object target;

    public UserServiceProxy(Object target) {
        this.target = target;
    }

    public UserService getProxy() {
        return (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

}