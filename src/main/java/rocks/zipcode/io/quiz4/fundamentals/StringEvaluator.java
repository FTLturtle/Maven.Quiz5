package rocks.zipcode.io.quiz4.fundamentals;

import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class StringEvaluator {
    public static String[] getAllSubstrings(String string) {
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

    public static String[] getCommonSubstrings(String string1, String string2) {
        Set<String> checkDuplicates = new HashSet<>(Arrays.asList(getAllSubstrings(string1)));
        List<String> commonSubstrings = new ArrayList<>(checkDuplicates.size());

        String[] strArr2 = getAllSubstrings(string2);
        for (String string : strArr2) {
            if (!checkDuplicates.add(string)) {
                commonSubstrings.add(string);
            }
        }

        return commonSubstrings.toArray(new String[0]);
    }

    public static String getLargestCommonSubstring(String string1, String string2) {
        return Arrays.stream(getCommonSubstrings(string1, string2)).max(Comparator.comparingInt(String::length)).get();
    }
}
