//package com.sailfish.Guess_Number;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.stubbing.Answer;
//
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.anyList;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
///**
// * @author sailfish
// * @create 2019-05-22-20:57
// */
//public class GameControllerTest {
//
//    @Mock
//    private GameView mockGameView;
//    @Mock
//    private InputCommand mockCommand;
//    @Mock
//    private AnswerGenerator mockGenerator;
//
//    private Game game;
//    private Answer correctAnswer;
//    private Answer errorAnswer;
//    private GameController gameController;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        correctAnswer = Answer.createAnswer("1 2 3 4");
//        errorAnswer = Answer.createAnswer("1 2 5 6");
//
//        when(mockGenerator.generate()).thenReturn(correctAnswer);
//        game = new Game(mockGenerator);
//        gameController = new GameController(game, mockGameView);
//    }
//
//    @Test
//    public void should_display_guess_history_message_when_guess_number_twice() {
//        //given
//        when(mockCommand.input()).thenReturn(errorAnswer);
//        GameController gameController = new GameController(game, mockGameView);
//
//        //when
//        gameController.play(mockCommand);
//
//        //then
//        verify(mockGameView).showGuessHistory(anyList());
//    }
//}