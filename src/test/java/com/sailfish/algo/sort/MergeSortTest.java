package com.sailfish.algo.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arr = new int[]{3, 5, 4, 1, 2, 6};
        System.out.println("before:" + Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort();
        System.out.println("after: " + Arrays.toString(mergeSort.sort(arr)));
    }
}