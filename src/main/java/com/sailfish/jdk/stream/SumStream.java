/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.jdk.stream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author chengyi
 * @version : SumStream.java, v 0.1 2021年02月18日 10:38 下午 chengyi Exp $
 */
public class SumStream {



    public static void main(String[] args) {
        System.out.println(sequentialSum(100000));
        System.out.println(sideEffectSum(100000));
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .parallel()
                .limit(n)
                .reduce(0L, Long::sum);
    }


    // 这段代码不是线程安全的
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }


}