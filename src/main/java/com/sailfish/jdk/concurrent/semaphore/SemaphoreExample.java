/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chengyi
 * @version : SemaphoreExample.java, v 0.1 2020年12月13日 8:10 下午 chengyi Exp $
 */
public class SemaphoreExample {

    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("acquire a permit.");
                        int value = new Random().nextInt(5);
                        TimeUnit.SECONDS.sleep(value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    semaphore.release();
                }
            });
        }
        shutdownAndAwaitTermination(executorService);
        System.out.println("all complete.");
    }

    static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}