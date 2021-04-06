/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.example.redPacket;

import java.math.BigDecimal;

/**
 * 红包算法
 * @author chengyi
 * @version : RedPacket.java, v 0.1 2021年03月21日 10:12 下午 chengyi Exp $
 */
public class RedPacket {

    public void grabRedPacket(int redPacketNum, BigDecimal money) {
        // 参数校验：最小金额为0.01 * 红包数量
        BigDecimal minRedPacketMoney = new BigDecimal("0.01");
        if (money.compareTo(minRedPacketMoney.multiply(new BigDecimal(redPacketNum))) < 0) {
            return;
        }
        BigDecimal remainderMoney = money;

        int[] arr = new int[]{};
        for (int i : arr) {

        }
    }



}