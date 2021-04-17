package com.sailfish.algo.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {


    @Test
    public void testBubbleTest01() {
        int[] arr = new int[]{3, 5, 4, 1, 2, 6};
        System.out.println("before:" + Arrays.toString(arr));
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("after: " + Arrays.toString(bubbleSort.bubbleSort(arr)));
    }
}