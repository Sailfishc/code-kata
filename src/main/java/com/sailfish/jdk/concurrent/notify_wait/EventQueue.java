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
public class EventQueue {

    private final int max;

    static class Event {

    }

    private static LinkedList<Event> queue = new LinkedList<>();
    private static final int DEFAULT_MAX_EVENT = 5;


    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (queue) {
            if (queue.size() >= max) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(event);
            queue.notify();
        }
    }

    public Event take() {
        synchronized (queue) {
            if (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = queue.removeLast();
            queue.notify();
            return event;
        }
    }
}