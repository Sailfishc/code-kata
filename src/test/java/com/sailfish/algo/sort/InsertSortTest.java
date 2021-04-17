package com.sailfish.algo.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertSortTest {

    @Test
    public void insertSort() {
        int[] arr = new int[]{3, 5, 4, 1, 2, 6};
        System.out.println("before:" + Arrays.toString(arr));
        InsertSort insertSort = new InsertSort();
        System.out.println("after: " + Arrays.toString(insertSort.insertSort(arr)));
    }
}