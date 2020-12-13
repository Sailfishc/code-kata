/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chengyi
 * @version : DeadLockExample.java, v 0.1 2020年12月13日 9:04 下午 chengyi Exp $
 */
public class DeadLockExample {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void method1() {
        try {
            lock1.lock();
            try {
                lock2.lock();
            } finally {
                lock2.lock();
            }
        } finally {
            lock1.lock();
        }
    }

    public static void method2() {
        try {
            lock2.lock();
            try {
                lock1.lock();
            } finally {
                lock1.lock();
            }
        } finally {
            lock2.lock();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    method1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    method2();
                }
            }
        }).start();


    }
}