package com.sailfish.tdd.Guess_Number;

import com.google.inject.Inject;

/**
 * @author sailfish
 * @create 2019-05-22-20:56
 */
public class AnswerGenerator {

    private RandomIntGenerator randomIntGenerator;
    @Inject
    public AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }
}
