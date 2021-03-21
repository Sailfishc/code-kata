/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.jdk.base.extend;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2021年02月18日 11:27 上午 chengyi Exp $
 */
public class Client {


    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();

        map.put("dog", new Dog());
        map.put("cat", new Cat());

        Animal animal = (Animal) map.get("dog");
        Dog dog = (Dog) animal;
//        Cat cat = (Cat) animal;

    }
}