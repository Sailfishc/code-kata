/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author chengyi
 * @version : Fibonacci.java, v 0.1 2020年12月14日 7:18 下午 chengyi Exp $
 */
public class Fibonacci extends RecursiveTask<Integer> {

    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        Fibonacci n1 = new Fibonacci(n - 1);
        n1.fork();
        Fibonacci n2 = new Fibonacci(n - 2);
        return n2.compute() + n1.join();
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(10);
        Integer result = ForkJoinPool.commonPool().invoke(f);
        System.out.println(result);
    }
}