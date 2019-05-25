//package com.sailfish.Guess_Number;
//
///**
// * @author sailfish
// * @create 2019-05-22-20:54
// */
//public class GameController {
//    private static final int MAX_TIMES = 6;
//    private Game game;
//    private GameView gameView;
//
//    public GameController(Game game, GameView gameView) {
//        this.game = game;
//        this.gameView = gameView;
//    }
//    public void play(InputCommand inputCommand) {
//        GuessResult guessResult;
//        do {
//            Answer inputAnswer = inputCommand.input();
//            guessResult = game.guess(inputAnswer);
//            gameView.showCurrentResult(guessResult);
//            gameView.showGuessHistory(game.guessHistory());
//        } while (!guessResult.correct() && game.guessHistory().size() < MAX_TIMES);
//
//        gameView.showMessage(guessResult.correct() ? "successful" : "failed");
//        gameView.showMessage("The correct number is " + game.actualAnswer());
//    }
//}
