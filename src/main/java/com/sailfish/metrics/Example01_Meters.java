/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.metrics;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * @author chengyi
 * @version : MetersExample.java, v 0.1 2020年12月14日 7:57 下午 chengyi Exp $
 */
public class Example01_Meters {

    private final MetricRegistry metrics = new MetricRegistry();
    private final Meter requests = metrics.meter("requests");

    public void handleRequest() {
        requests.mark();
        // etc
    }

    public static void main(String[] args) {
        Example01_Meters example01Meters = new Example01_Meters();
        example01Meters.handleRequest();
    }
}