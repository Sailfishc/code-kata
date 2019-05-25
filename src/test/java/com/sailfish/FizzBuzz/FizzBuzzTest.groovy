package com.sailfish.FizzBuzz

/**
 * @author sailfish* @create 2019-05-25-15:40
 */
class FizzBuzzTest extends spock.lang.Specification {


    def "number % 15 is 0"() {
        given:
        int number = 30
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        boolean flag = fizzBuzz.checkNumberIsFizzBuzz(number)

        then:
        true == flag

    }

    def "number % 5 is 0"() {
        given:
        int number = 30
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        boolean flag = fizzBuzz.checkNumberIsBuzz(number)

        then:
        true == flag

    }


    def "number % 3 is 0"() {
        given:
        int number = 30
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        boolean flag = fizzBuzz.checkNumberIsFizz(number)

        then:
        true == flag
    }

    def "play game"() {
        given:
        int number = 30
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        String result = fizzBuzz.play(number)

        then:
        "FizzBuzz" == result
    }

    def "println game"() {
        given:
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        fizzBuzz.run()

        then:
        true

    }


}
