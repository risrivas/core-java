package udemy.java.masterclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenges {

    public static void main(String[] args) {
//        challenge1();
//        challenge2_3();
        challenge4_5();
    }

    private static void challenge4_5() {
        String challenge4 = "Replace all blanks with underscore.";
        System.out.println(challenge4.replaceAll("\\s", "_"));
        System.out.println(challenge4.replaceAll(" ", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.matches("[a-g]+"));

        String challenge7 = "abcd.135";
//        String challenge7regex = "^[a-z]+\\.[0-9]+$";
        String challenge7regex = "^[a-z]+\\.\\d+$";
        System.out.println(challenge7.matches(challenge7regex));
        System.out.println("f5.12a".matches(challenge7regex));
    }

    private static void challenge2_3() {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

//        final String regex = "I want a .*";
        final String regex1 = "I want a \\w+.";
        System.out.println(challenge1.matches(regex1));
        System.out.println(challenge2.matches(regex1));

        final String regex2 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regex2));
        System.out.println(challenge2.matches(regex2));

        Pattern pattern3 = Pattern.compile(regex1);
        Matcher matcher3 = pattern3.matcher(challenge1);
        System.out.println(matcher3.matches());

        matcher3 = pattern3.matcher(challenge2);
        System.out.println(matcher3.matches());
    }

    private static void challenge1() {
        String challenge1 = "I want a bike.";
//        String text = "Its a beautiful day and I want to go to roam around the mountains in my bike. I want a bike. See you in 2 min";
//        System.out.println(text.matches(".*" + challenge1 + ".*"));
        System.out.println(challenge1.matches("I want a bike."));
    }
}
