package rocks.zipcode.io.quiz4.objectorientation;

import rocks.zipcode.io.quiz4.fundamentals.StringEvaluator;

import java.util.*;

/**
 * @author leon on 19/12/2018.
 */
public class StringEvaluatorObject {
    private String string;

    public StringEvaluatorObject(String str) {
        this.string = str;
    }

    @SuppressWarnings("Duplicates")
    public String[] getAllSubstrings() {
        int strLen = string.length();
        String[] substrings = new String[(strLen * (strLen + 1)) / 2];
        int subCount = 0;
        for (int i = 0; i < strLen; i++) {
            for (int j = i + 1; j <= strLen; j++) {
                substrings[subCount] = string.substring(i, j);
                subCount++;
            }
        }
        return Arrays.stream(substrings).distinct().toArray(String[]::new);
    }

    @SuppressWarnings("Duplicates")
    public String[] getCommonSubstrings(String secondInput) {
        Set<String> checkDuplicates = new HashSet<>(Arrays.asList(getAllSubstrings()));
        List<String> commonSubstrings = new ArrayList<>(checkDuplicates.size());

        StringEvaluatorObject seo = new StringEvaluatorObject(secondInput);
        String[] strArr2 = seo.getAllSubstrings();
        for (String string : strArr2) {
            if (!checkDuplicates.add(string)) {
                commonSubstrings.add(string);
            }
        }

        return commonSubstrings.toArray(new String[0]);
    }

    public String getLargestCommonSubstring(String secondInput) {
        return Arrays.stream(getCommonSubstrings(secondInput)).max(Comparator.comparingInt(String::length)).get();
    }
}
