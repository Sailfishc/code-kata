//package com.sailfish.Guess_Number;
//
///**
// * @author sailfish
// * @create 2019-05-22-20:55
// */
//public class GuessNumber {
//
//    public static void main(String[] args) {
//        Injector injector = createInjector(new GuessNumberModule());
//        GameController gameController = injector.getInstance(GameController.class);
//        InputCommand command = new ConsoleInputCommand();
//
//        System.out.println("Please input four numbers following by X X X X(0--9)");
//        gameController.play(command);
//    }
//}
