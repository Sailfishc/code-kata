/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.base.linkedlist;

import com.sailfish.util.ListNodeHelper;

/**
 * @author chengyi
 * @version : AddLinkedList.java, v 0.1 2021年04月13日 5:39 下午 chengyi Exp $
 */
public class AddLinkedList {


    public static void main(String[] args) {
        ListNode head = null, tail = null;
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            if (head == null) {
                head = tail = new ListNode(i);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        ListNodeHelper.printListNode(head);
    }


}