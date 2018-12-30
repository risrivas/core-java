package udemy.java.masterclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenges {

    public static void main(String[] args) {
        challenge1();
        challenge2_3();
        challenge4_14();
    }

    private static void challenge4_14() {
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

        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8regex = "([a-z]+)(\\.)(\\d+)";
        Pattern ch8pattern = Pattern.compile(challenge8regex);
        Matcher ch8matcher = ch8pattern.matcher(challenge8);
        while (ch8matcher.find()) {
            System.out.println(ch8matcher.group(3));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge9regex = "([a-z]+)(\\.)(\\d+)(\\s+)";
        Pattern ch9pattern = Pattern.compile(challenge9regex);
        Matcher ch9matcher = ch9pattern.matcher(challenge9);
        while (ch9matcher.find()) {
            System.out.println("Occurrences: " + ch9matcher.group(3)
                    + "; start: " + ch9matcher.start(3)
                    + "; end: " + (ch9matcher.end(3) - 1));
        }


        String challenge11 = "{0, 2}, {0,5}, {1, 3}, {2, 4}";
//        String ch11regex = "(\\{)(\\d,\\s*\\d)(\\})";
        String ch11regex = "(\\{)(.+?)(\\})";
        Pattern ch11pattern = Pattern.compile(ch11regex);
        Matcher ch11matcher = ch11pattern.matcher(challenge11);
        while (ch11matcher.find()) {
            System.out.println(ch11matcher.group(2));
        }

        String challenge12 = "11111";
        Pattern ch12pattern = Pattern.compile("^\\d{5}$");
        Matcher ch12matcher = ch12pattern.matcher(challenge12);
        System.out.println(ch12matcher.matches());

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        System.out.println(challenge12.matches("^\\d{5}+(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}+(-\\d{4})?$"));
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
