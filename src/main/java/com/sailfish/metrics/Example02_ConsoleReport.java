/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author chengyi
 * @version : ConsoleReportExample.java, v 0.1 2020年12月20日 7:42 下午 chengyi Exp $
 */
public class Example02_ConsoleReport {

    private static final MetricRegistry metrics = new MetricRegistry();
    private static final Meter requests = metrics.meter("requests");

    public static void main(String[] args) throws InterruptedException {

        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);

        for (int i = 0; i < 20; i++) {
            handleRequest();
        }

        TimeUnit.SECONDS.sleep(2);
    }

    public static void handleRequest() {
        requests.mark();
        // etc
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}