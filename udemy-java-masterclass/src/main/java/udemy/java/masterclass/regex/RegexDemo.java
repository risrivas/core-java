package udemy.java.masterclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class RegexDemo {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        out.println(string);
        String yourString = string.replaceAll("I", "You");
        out.println(yourString);

        String alphanumeric = "abcDeeeF123GhhhiJkkkkkLmnnnnn";
        out.println(alphanumeric.replaceAll(".", "Y"));

        out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        out.println(alphanumeric.matches("^hello"));
        out.println(alphanumeric.matches("^abcDeee")); // no square brackets
        out.println(alphanumeric.matches("abcDeeeF123GhhhiJkkkkkLmnnnnn"));

        out.println(alphanumeric.replaceAll("nnn$", "THE END"));
        out.println(alphanumeric.replaceAll("[aei]", "X"));
        out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        out.println(newAlphanumeric.replaceAll("[^ej]", "X")); // square brackets - not

        out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        out.println(newAlphanumeric.replaceAll("[a-f3-8]", "X"));

        out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        out.println(newAlphanumeric.replaceAll("(?iu)[a-f3-8]", "X"));

        out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        out.println(newAlphanumeric.replaceAll("\\d", "X"));
        out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        out.println(hasWhitespace);
        out.println(hasWhitespace.replaceAll("\\s", ""));
        out.println(hasWhitespace.replaceAll("\t", "X"));
        out.println(hasWhitespace.replaceAll("\\S", "X"));

        out.println(newAlphanumeric.replaceAll("\\w", "X"));
        out.println(hasWhitespace.replaceAll("\\w", "X"));
        out.println(hasWhitespace.replaceAll("\\b", "X"));

        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        out.println(thirdAlphanumeric.replaceAll("^abcDeee", "YYY"));
        out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY")); // quantifier
        out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));
        out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        out.println(thirdAlphanumeric.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(htmlText);
        out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        out.println("harry".replaceAll("[H|h]arry", "Larry"));
        out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phoneNumberRegex = "^([\\(][0-9]{3}[\\)][ ][0-9]{3}[\\-][0-9]{4})$";
        Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);
        Matcher phNumberMatcher = phoneNumberPattern.matcher("(123) 456-7890");
        out.println(phNumberMatcher.matches());

        String visaRegex = "^4[0-9]{12}([0-9]{3})?$";
        out.println("4555555555555".matches(visaRegex));
        out.println("4555555555555888".matches(visaRegex));
        out.println("4555556555555897".matches(visaRegex));

    }

}
