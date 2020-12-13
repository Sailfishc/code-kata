/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.util;

/**
 * @author chengyi
 * @version : ThreadUtil.java, v 0.1 2020年12月13日 7:55 下午 chengyi Exp $
 */
public class ThreadUtil {


    public static String currentThread() {
        return "Thread[" + Thread.currentThread().getName() + "]";
    }

}