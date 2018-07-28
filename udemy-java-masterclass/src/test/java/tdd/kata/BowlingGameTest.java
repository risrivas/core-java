package tdd.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

   BowlingGame game;

   @Before
   public void setUp() {
      game = new BowlingGame();
   }

   @Test
   public void testGutterGame() {
      rollMany(20, 0);
      assertThat(game.score(), is(0));
   }

   @Test
   public void allOnes() {
      rollMany(20, 1);
      assertThat(game.score(), is(20));
   }

   @Test
   public void testOneSpare() {
      game.roll(5);
      game.roll(5);
      game.roll(3);
      rollMany(17, 0);
      assertThat(game.score(), is(16));
   }

   @Test
   public void testOneStrike() {
      game.roll(10);
      game.roll(3);
      game.roll(4);
      rollMany(16, 0);
      assertThat(game.score(), is(24));
   }

   @Test
   public void testPerfectGame() {
      rollMany(12, 10);
      assertThat(game.score(), is(300));
   }

   @Test
   public void playCompleteGame() {
      game.roll(1);
      game.roll(4);

      game.roll(4);
      game.roll(5);

      game.roll(6);
      game.roll(4);

      game.roll(5);
      game.roll(5);

      game.roll(10);

      game.roll(0);
      game.roll(1);

      game.roll(7);
      game.roll(3);

      game.roll(6);
      game.roll(4);

      game.roll(10);

      game.roll(2);
      game.roll(8);
      game.roll(6);

      assertThat(game.score(), is(133));
   }

   private void rollMany(int n, int pins) {
      for (int i = 0; i < n; i++) {
         game.roll(pins);
      }
   }

}
