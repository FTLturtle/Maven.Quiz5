package rocks.zipcode.io.quiz4.fundamentals;

import java.util.Arrays;

/**
 * @author leon on 18/12/2018.
 */
public class PalindromeEvaluator {
    public static String[] getAllPalindromes(String string) {
        return Arrays.stream(StringEvaluator.getAllSubstrings(string)).filter(PalindromeEvaluator::isPalindrome).toArray(String[]::new);
    }

    public static Boolean isPalindrome(String string) {
        return string.equals(reverseString(string));
    }

    public static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }
}
