/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.base.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author chengyi
 * @version : ListNode.java, v 0.1 2021年04月13日 5:40 下午 chengyi Exp $
 */
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}