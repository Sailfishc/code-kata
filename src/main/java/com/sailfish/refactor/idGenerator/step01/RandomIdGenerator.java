/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.idGenerator.step01;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author chengyi
 * @version : IdGenerator.java, v 0.1 2021年03月21日 7:59 下午 chengyi Exp $
 */
@Slf4j
public class RandomIdGenerator implements IdGenerator {

    private static final int number = 122;

    @Override
    public String generate() {
        String alphameric = generateRandomAlphameric();
        String id = String.format("%s-%d-%s", getHostName(),
                System.currentTimeMillis(), alphameric);

        return id;
    }

    private String generateRandomAlphameric() {
        char[] randomChars = new char[8];
        int count = 0;
        while (count < 8) {
            int randomAscii = genAscii();
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }

    /**
     * 生成Ascii码
     * @return
     */
    protected int genAscii() {
        Random random = new Random();
        return random.nextInt(number);
    }


    protected String getHostName() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            return hostName;
        } catch (UnknownHostException e) {
            log.error("Failed to get the host name.", e);
            throw new RuntimeException("get hostname error");
        }
    }
}