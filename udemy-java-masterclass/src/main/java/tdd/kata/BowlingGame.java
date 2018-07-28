package tdd.kata;

public class BowlingGame {
   private int score;
   private int[] rolls = new int[21];
   private int currentRollIndex;

   public void roll(int pins) {
      rolls[currentRollIndex++] = pins;
   }

   public int score() {
      int i = 0;
      for (int frame = 0; frame < 10; frame++) {
         if (frame == 9) {
            while (i < rolls.length) {
               score += rolls[i];
               i++;
            }
         } else if (isStrike(i)) {
            score += 10 + strikeBonus(i);
            i += 1;
         } else if (isSpare(i)) {
            score += 10 + spareBonus(i);
            i += 2;
         } else {
            score += normalScoreWithNoBonus(i);
            i += 2;
         }
      }

      return score;
   }

   private boolean isStrike(int i) {
      return rolls[i] == 10;
   }

   private int strikeBonus(int i) {
      return rolls[i + 1] + rolls[i + 2];
   }

   private int normalScoreWithNoBonus(int i) {
      return rolls[i] + rolls[i + 1];
   }

   private int spareBonus(int i) {
      return rolls[i + 2];
   }

   private boolean isSpare(int i) {
      return (rolls[i] + rolls[i + 1] == 10);
   }

}
