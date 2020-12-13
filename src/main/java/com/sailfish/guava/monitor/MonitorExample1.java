/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.guava.monitor;

import com.google.common.util.concurrent.Monitor;

import static com.sailfish.util.ThreadUtil.currentThread;

/**
 * @author chengyi
 * @version : MonitorExample1.java, v 0.1 2020年12月13日 6:51 下午 chengyi Exp $
 */
public class MonitorExample1 {

    // Monitor对象
    private static Monitor monitor = new Monitor();
    // 模拟共享数据
    private static int data = 0;
    private static final int MAX_VALUE = 10;
    private static final Monitor.Guard INC_WHEN_LESS_10 = new Monitor.Guard(monitor) {
        // 相当于使用Condition时临界区的判断
        @Override
        public boolean isSatisfied() {
            return data < MAX_VALUE;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            try {
                monitor.enterWhen(INC_WHEN_LESS_10);
                data++;
                System.out.println(currentThread() + ": data value is " + data);
            }finally {
                monitor.leave();
            }
        }
    }


}