/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.algo.sort;

/**
 * @author chengyi
 * @version : BubbleSort.java, v 0.1 2021年04月16日 3:03 下午 chengyi Exp $
 */
public class InsertSort {

    public int[] insertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    // 数组向右移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 这一步进行替换
            arr[j + 1] = value;
        }
        return arr;
    }

}