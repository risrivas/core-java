package tdd.kata;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicTacToeTest {

   OutputStream out = new ByteArrayOutputStream();
   TicTacToe ticTacToe = new TicTacToe(new PrintStream(out));

   private String output() {
      return out.toString().replaceAll("\r\n", "\n").trim();
   }

   @After
   public void tearDown() {
      try {
         out.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Rule
   public ExpectedException exception = ExpectedException.none();

   @Test
   public void gameStartsWithEmptyBoard() {
      String board =
            "1 | | | |\n" +
            "2 | | | |\n" +
            "3 | | | |\n" +
            "   a b c\n" +
            "\n" +
            "Player [X] turn:";

      assertThat(output(), is(board));
   }

   @Test
   public void askForXtoPlayFirstTime() {
      ticTacToe.play("2b");

      assertThat(ticTacToe.renderBoard(), is(
         "1 | | | |\n" +
              "2 | |X| |\n" +
              "3 | | | |\n" +
              "   a b c"
      ));
   }


   @Test
   public void askForOtoPlaySecondTime() {
      ticTacToe.play("2b");
      ticTacToe.play("2a");

      assertThat(ticTacToe.renderBoard(), is(
         "1 | | | |\n" +
              "2 |O|X| |\n" +
              "3 | | | |\n" +
              "   a b c"
      ));
   }

   @Test
   public void ifCoordinatesOutOfRangeThenThrowException() {
      exception.expect(CoordinatesOutOfRangeException.class);
      exception.expectMessage("coordinates are out of range");
      ticTacToe.play("5b");
   }

   @Test
   public void ifPlacedOntheOccupiedSlotThenThrowException() {
      ticTacToe.play("2b");
      exception.expect(AlreadyOccupiedSlotException.class);
      exception.expectMessage("slot already occupied");
      ticTacToe.play("2b");
   }

   @Test
   public void whenAllVerticalSameThenPlayerWins() {
      ticTacToe.play("3a");
      ticTacToe.play("2b");
      ticTacToe.play("2a");
      ticTacToe.play("1b");
      ticTacToe.play("1a");

      assertThat(output(), containsString("Player [X] wins!!"));
   }

   @Test
   public void whenAllHorizontalSameThenPlayerWins() {
      ticTacToe.play("3a");
      ticTacToe.play("2b");
      ticTacToe.play("3b");
      ticTacToe.play("1b");
      ticTacToe.play("3c");

      assertThat(output(), containsString("Player [X] wins!!"));
   }

   @Test
   public void whenDiagonalLeftToptoBottomRightSameThenPlayerWins() {
      ticTacToe.play("1a");
      ticTacToe.play("2a");
      ticTacToe.play("2b");
      ticTacToe.play("1b");
      ticTacToe.play("3c");

      assertThat(output(), containsString("Player [X] wins!!"));
   }

   @Test
   public void whenDiagonalLeftBottomToTopRightSameThenPlayerWins() {
      ticTacToe.play("3a");
      ticTacToe.play("2a");
      ticTacToe.play("2b");
      ticTacToe.play("1b");
      ticTacToe.play("1c");

      assertThat(output(), containsString("Player [X] wins!!"));
   }

   @Test
   public void gameEndsWithNoWinnerAsADraw() {
      ticTacToe.play("1a"); // X
      ticTacToe.play("2a"); // O
      ticTacToe.play("3a"); // X
      ticTacToe.play("2b"); // XXO
      ticTacToe.play("1b"); // OOX
      ticTacToe.play("3b"); // XOX
      ticTacToe.play("2c");
      ticTacToe.play("1c");
      ticTacToe.play("3c");

      assertThat(output(), containsString("Game ends in a DRAW!!"));
   }


}
