package rocks.zipcode.io.quiz4.objectorientation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon on 18/12/2018.
 */
public class PalindromeObject {
    private String string;

    public PalindromeObject(String input) {
        this.string = input;
    }

    public String[] getAllPalindromes(){
        StringEvaluatorObject seo = new StringEvaluatorObject(string);
        List<String> palindromes = new ArrayList<>();
        PalindromeObject po;
        for (String string : seo.getAllSubstrings()) {
            po = new PalindromeObject(string);
            if (po.isPalindrome()) {
                palindromes.add(string);
            }
        }
        return palindromes.toArray(new String[0]);
    }

    public Boolean isPalindrome(){
        return string.equals(reverseString());
    }

    public String reverseString(){
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }
}
