package tdd.kata;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class TicTacToe {

   private static final int ROWS = 3;
   private static final int COLS = 3;

   private String[][] board;
   private PrintStream outputChannel;
   private String currentPlayer = "X";

   private static boolean gotTheWinner;
   private static boolean itIsDraw;

   private static final String DELIMITER = "|";
   private static final String EMPTY = " ";

   public TicTacToe(PrintStream out) {
      outputChannel = out;
      board = new String[ROWS][COLS];
      for (String[] row : board) {
         Arrays.fill(row, EMPTY);
      }
      printBoard();
      printPlayersTurn();
   }

   private void printBoard() {
      outputChannel.println(renderBoard());
   }

   private void printPlayersTurn() {
      outputChannel.printf("%nPlayer [%s] turn: %n", currentPlayer);
   }

   public String renderBoard() {
      StringBuilder displaySB = new StringBuilder();
      for (int row = 0; row < 3; row++) {
         StringJoiner joiner =
            new StringJoiner(DELIMITER,
               String.valueOf(row + 1) + " " + DELIMITER,
               DELIMITER + "\n");

         for (int col = 0; col < 3; col++) {
            joiner.add(board[row][col]);
         }

         displaySB.append(joiner);
      }

      displaySB.append("   a b c");

      return displaySB.toString();
   }

   public void play(String input) {
      int[] coordinates = getCoordinates(input);
      if (!board[coordinates[0]][coordinates[1]].trim().isEmpty())
         throw new AlreadyOccupiedSlotException("slot already occupied");
      board[coordinates[0]][coordinates[1]] = currentPlayer;
      printBoard();
      if (checkIfWinner(coordinates)) {
         gotTheWinner = true;
         outputChannel.printf("%nPlayer [%s] wins!!%n", currentPlayer);
      } else if (checkIfDraw()) {
         itIsDraw = true;
         outputChannel.printf("%nGame ends in a DRAW!!%n");
      } else {
         switchPlayer();
         printPlayersTurn();
      }
   }

   private boolean checkIfDraw() {
      for (int row = 0; row < ROWS; row++) {
         for (int col = 0; col < COLS; col++) {
            if (board[row][col].trim().isEmpty()) return false;
         }
      }

      return true;
   }

   private boolean checkIfWinner(int[] coordinates) {
      return checkVerticalWinner(coordinates)
         || checkHorizontalWinner(coordinates)
         || checkDiagonalTopLeftToBottomRightWinner()
         || checkDiagonalBottomLeftToTopRightWinner();
   }

   private boolean checkDiagonalTopLeftToBottomRightWinner() {
      Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{3}.*");
      String diagonal = board[0][0] + board[1][1] + board[2][2];

      return winPattern.matcher(diagonal).matches();
   }

   private boolean checkDiagonalBottomLeftToTopRightWinner() {
      Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{3}.*");
      String diagonal = board[2][0] + board[1][1] + board[0][2];

      return winPattern.matcher(diagonal).matches();
   }


   private boolean checkVerticalWinner(int[] coordinates) {
      Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{3}.*");
      int column = coordinates[1];
      String vertical = IntStream.range(0, ROWS)
         .mapToObj(r -> board[r][column])
         .filter(s -> !s.isEmpty())
         .reduce(String::concat).get();

      return winPattern.matcher(vertical).matches();
   }

   private boolean checkHorizontalWinner(int[] coordinates) {
      Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{3}.*");
      int row = coordinates[0];
      String horizontal = IntStream.range(0, COLS)
         .mapToObj(c -> board[row][c])
         .filter(s -> !s.isEmpty())
         .reduce(String::concat).get();

      return winPattern.matcher(horizontal).matches();
   }


   private void switchPlayer() {
      if (currentPlayer.equals("X"))
         currentPlayer = "O";
      else currentPlayer = "X";
   }

   private int[] getCoordinates(String input) {
      int x = Character.getNumericValue(input.charAt(0)) - 1;
      int y = input.charAt(1) - 'a';

      if (x < 0 || x > 2 || y < 0 || y > 2) {
         throw new CoordinatesOutOfRangeException("coordinates are out of range");
      }

      return new int[]{x, y};
   }

   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         TicTacToe ticTacToe = new TicTacToe(System.out);
         while (!isGameEnd()) {
            ticTacToe.play(scanner.next());
         }
      }
   }

   private static boolean isGameEnd() {
      return gotTheWinner || itIsDraw;
   }
}
