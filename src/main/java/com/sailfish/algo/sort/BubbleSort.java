/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.algo.sort;

/**
 * @author chengyi
 * @version : BubbleSort.java, v 0.1 2021年04月16日 3:03 下午 chengyi Exp $
 */
public class BubbleSort {


    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }


}