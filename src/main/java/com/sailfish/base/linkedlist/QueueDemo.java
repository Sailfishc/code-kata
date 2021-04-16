/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.base.linkedlist;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

/**
 * @author chengyi
 * @version : QueueDemo.java, v 0.1 2021年04月16日 12:38 下午 chengyi Exp $
 */
public class QueueDemo {


    public static void main(String[] args) {
        try {
            Queue<Integer> queue = new ArrayBlockingQueue<>(3);
            IntStream.range(0, 10).forEach(i -> queue.add(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Queue<Integer> queue = new ArrayBlockingQueue<>(3);
            IntStream.range(0, 10).forEach(i -> System.out.println(queue.offer(i)));
            System.out.println("删除队列元素---");
            IntStream.range(0, 10).forEach(i -> System.out.println(queue.remove()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Queue<Integer> queue = new ArrayBlockingQueue<>(3);
            IntStream.range(0, 10).forEach(i -> queue.offer(i));
            System.out.println("删除队列元素---");
            IntStream.range(0, 10).forEach(i -> System.out.println(queue.poll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}