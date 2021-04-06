/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.program;

/**
 * @author chengyi
 * @version : IpCheck.java, v 0.1 2021年04月06日 5:25 下午 chengyi Exp $
 */
public class IpCheck {

    /**
     * 规则：
     * - 只能是空格，数字和.
     * - 由4组数字构成，有.分隔，数字大小在0-255之间
     * - 数字前后可以有空格，中间不能有空格
     * case:
     * - 123.9.2.0  合法
     * - 223.  33. 13. 33 合法
     * - 232. 22 1. 223. 1  非法
     * - 222 . 319.  2 . 4  非法
     * - 2ba. 23. 34.11  非法
     * - 232. 232. 11 非法
     * - 233.  .   33. 2 非法
     * - "" 或者是 null  非法
     */

    public boolean check(String ip) {
        if (ip == null) {
            return false;
        }

        final String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }

        for (String s : ipArr) {
            boolean valid = check2(s);
            if (!valid) {
                return false;
            }
        }

        return true;
    }

    private boolean check2(String s) {
        // 校验是否为空字符
        final int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return false;
        }
        // 判断数字
        int digit = 0;
        while (i < n && s.charAt(i) != ' ') {
            final char c = s.charAt(i);
            // 是否为数字
            if (c < '0' || c > '9') {
                return false;
            }
            // 校验字符是否在0-255之间
            digit = digit * 10 + (c - '0');
            if (digit > 255) {
                return false;
            }
            i++;
        }

        // 后置空格,如果包含非空格，则不符合
        while (i < n) {
            final char c = s.charAt(i);
            if (c != ' ') {
                return false;
            }
            i++;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new IpCheck().check("123.9.2.0"));
        System.out.println(new IpCheck().check("232. 232. 11"));
        System.out.println(new IpCheck().check("222 . 319.  2 . 4"));
        System.out.println(new IpCheck().check(" "));
    }
}