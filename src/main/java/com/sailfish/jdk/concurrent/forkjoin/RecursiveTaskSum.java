/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.jdk.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author chengyi
 * @version : RecursiveSumTask.java, v 0.1 2020年12月14日 5:51 下午 chengyi Exp $
 */
public class RecursiveTaskSum extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int startIndex;
    private final int endIndex;
    private static final long THRESHOD = 10_000L;

    public RecursiveTaskSum(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public RecursiveTaskSum(long[] numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected Long compute() {
        int length = endIndex - startIndex;
        if (length <= THRESHOD) {
            long result = 0;
            for (int i = startIndex; i < endIndex; i++) {
                result += numbers[i];
            }
            return result;
        }
        int tempEndIndex = startIndex + length / 2;
        RecursiveTaskSum firstTask = new RecursiveTaskSum(numbers, startIndex, tempEndIndex);
        // 异步执行第一个拆分的子任务
        firstTask.fork();
        // 拆分第二个
        RecursiveTaskSum secondTask = new RecursiveTaskSum(numbers, tempEndIndex, endIndex);
        secondTask.fork();

        Long secondResult = secondTask.join();
        Long firstResult = firstTask.join();

        return firstResult + secondResult;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 9_000_000).toArray();
        RecursiveTaskSum forkJoinTask = new RecursiveTaskSum(numbers);

        Long result = ForkJoinPool.commonPool().invoke(forkJoinTask);
        System.out.println(result);

        assert result == LongStream.rangeClosed(1, 9_000_000).sum();
    }
}