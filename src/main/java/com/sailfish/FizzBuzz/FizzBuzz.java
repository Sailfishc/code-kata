package com.sailfish.FizzBuzz;

/**
 * @author sailfish
 * @create 2019-05-25-15:40
 */
public class FizzBuzz {


    public boolean checkNumberIsFizzBuzz(int p) {
        return p % 15 == 0;
    }

    public boolean checkNumberIsBuzz(int p) {
        return p % 5 == 0;
    }

    public boolean checkNumberIsFizz(int p) {
        return p % 3 == 0;
    }

    public String play(int p) {
        if (checkNumberIsFizzBuzz(p)) {
            return "FizzBuzz";
        }
        if (checkNumberIsBuzz(p)) {
            return "Buzz";
        }
        if (checkNumberIsFizz(p)) {
            return "Fizz";
        }
        return String.valueOf(p);
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(play(i));
        }
    }
}
