/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.refactor.idGenerator.step02;

import com.google.common.annotations.VisibleForTesting;
import com.sailfish.refactor.idGenerator.step01.IdGenerator;
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
        String alphameric = generateRandomAlphameric(8);
        long currentTimeMillis = System.currentTimeMillis();
        String id = String.format("%s-%d-%s", getLastFieldOfHostName(), currentTimeMillis
                , alphameric);

        return id;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < 8) {
            int randomAscii = genAscii(random);
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
     *
     * @return
     */
    private int genAscii(Random random) {
        return random.nextInt(number);
    }


    private String getLastFieldOfHostName() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String substrOfHostName = getLastSubstrSplittedByDot(hostName);
            return substrOfHostName;
        } catch (UnknownHostException e) {
            log.error("Failed to get the host name.", e);
            throw new RuntimeException("get hostname error");
        }
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

}