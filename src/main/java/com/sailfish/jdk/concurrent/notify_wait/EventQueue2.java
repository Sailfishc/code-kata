/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.notify_wait;

import java.util.LinkedList;

/**
 * @author chengyi
 * @version : EventQueue.java, v 0.1 2020年12月13日 9:15 下午 chengyi Exp $
 */
public class EventQueue2 {

    private final int max;

    static class Event {

    }

    private static LinkedList<Event> queue = new LinkedList<>();
    private static final int DEFAULT_MAX_EVENT = 5;


    public EventQueue2() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue2(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (queue) {
            while (queue.size() >= max) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(event);
            queue.notifyAll();
        }
    }

    public Event take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = queue.removeFirst();
            queue.notifyAll();
            return event;
        }
    }
}