/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.cyclicBarrier;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author chengyi
 * @version : CyclicBarrierExample.java, v 0.1 2020年12月13日 7:45 下午 chengyi Exp $
 */
public class CyclicBarrierExample2 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final int[] products = getProductByCategoryId();
        List<ProductPrice> productList = Arrays.stream(products)
                .mapToObj(ProductPrice::new)
                .collect(Collectors.toList());
        final CyclicBarrier barrier = new CyclicBarrier(productList.size() + 1, new Worker());
        List<Thread> threadList = Lists.newArrayList();
        productList.forEach(pp ->{
            Thread thread = new Thread(() -> {
                System.out.println(pp.getProductId() + "start cal price.");
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    if (pp.getProductId() % 2 == 0) {
                        pp.setPrice(pp.getProductId() * 0.71D);
                    } else {
                        pp.setPrice(pp.getProductId() * 0.9D);
                    }
                    System.out.println(pp.getProductId() +"->price cal completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        // 等待其他子线程到达barrier point
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(thread);
            thread.start();
        });

        // 等待其他子线程到达barrier point
        barrier.await();
        System.out.println("all complete.");
    }

    private static int[] getProductByCategoryId() {
        return IntStream.rangeClosed(1, 10).toArray();
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after computer .");
        }
    }
}