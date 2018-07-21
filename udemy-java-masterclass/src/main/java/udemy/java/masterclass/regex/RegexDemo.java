package udemy.java.masterclass.regex;

public class RegexDemo {

   public static void main(String[] args) {
      String string = "I am a string. Yes, I am.";
      System.out.println(string);
      String yourString = string.replaceAll("I", "You");
      System.out.println(yourString);

      String alphanumeric = "abcDeeeF123GhhhiJkkkkkLmnnnnn";
      System.out.println(alphanumeric.replaceAll(".", "Y"));

      System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

      System.out.println(alphanumeric.matches("^hello"));
      System.out.println(alphanumeric.matches("^abcDeee"));
   }

}
