package com.sailfish.refactor.idGenerator.step01;

import org.junit.Test;

public class IdGeneratorTest {


    @Test
    public void generate() {
        IdGenerator idGenerator = new RandomIdGenerator();
        String generate = idGenerator.generate();
        System.out.println(generate);
    }
}