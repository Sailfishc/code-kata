//package com.sailfish.tdd.Guess_Number;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.stubbing.Answer;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * @author sailfish
// * @create 2019-05-22-20:58
// */
//public class GameTest {
//
//    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
//    private Game game;
//
//    @Before
//    public void setUp() throws Exception {
//        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
//        when(answerGenerator.generate()).thenReturn(actualAnswer);
//        game = new Game(answerGenerator);
//    }
//
//    @Test
//    public void should_record_every_guess_result() {
//        game.guess(Answer.createAnswer("2 1 6 7"));
//        game.guess(Answer.createAnswer("1 2 3 4"));
//
//        List<GuessResult> guessHistory = game.guessHistory();
//
//        assertThat(guessResults.size(), is(2));
//        assertThat(guessResults.get(0).result(), is("0A2B"));
//        assertThat(guessResults.get(0).inputAnswer().toString(), is("2 1 6 7"));
//        assertThat(guessResults.get(1).result(), is("4A0B"));
//        assertThat(guessResults.get(1).inputAnswer().toString(), is("1 2 3 4"));
//    }
//}