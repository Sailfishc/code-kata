/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.algo.sort;

import java.util.Arrays;

/**
 * @author chengyi
 * @version : BubbleSort.java, v 0.1 2021年04月16日 3:03 下午 chengyi Exp $
 */
public class MergeSort {

    public int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int[] mergeSort(int[] arr, int p, int r) {
        if (p >= r) {
            return arr;
        }
        // 取中间位置
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);

        // merge
        merge(arr, p, q, r);
        return arr;
    }

    private void merge(int[] arr, int p, int q, int r) {
        // 将arr[p,r]排序后放入arr中
        final int[] temp = Arrays.copyOfRange(arr, p, r + 1);
        int i = p;
        int j = q + 1;
        for (int k = p; k <= r ; k++) {
            if (i > q) {
                arr[k] = temp[j - p];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - p];
                i++;
            } else if (temp[i - p] <= temp[j - p]) {
                arr[k] = temp[i - p];
                i++;
            } else {
                arr[k] = temp[j - p];
                j++;
            }
        }
    }

}