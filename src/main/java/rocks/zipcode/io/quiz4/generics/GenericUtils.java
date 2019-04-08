package rocks.zipcode.io.quiz4.generics;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {

    // The tests are not looking for powersets, but rather the list of all permutations

    // fake power set
    public static <T extends Comparable<T>> List<List<T>> powerSet(T[] elements) {
        int length = elements.length;
        List<List<T>> blah = new ArrayList<>();

        List<T> tempList = Arrays.asList(elements);
        Collections.sort(tempList);
        blah.add(Arrays.asList(elements));

        Set<Set<T>> powerSet = realPowerSet(Arrays.asList(elements));

        List<T> list = new ArrayList<>();
        for (Set<T> set : powerSet) {
            list.clear();
            list.addAll(set);
            if (list.size() < length) {
                blah.addAll(permutations(list));
            }
        }

        blah.sort(new ListComparator());

        return blah;
    }

    public static <T extends Comparable<T>> List<List<T>> permutations(List<T> elements) {
        List<List<T>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < elements.size(); i++) {
            ArrayList<ArrayList<T>> current = new ArrayList<>();
            for (List<T> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, elements.get(i));
                    ArrayList<T> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }

    // The below are methods for generating the actual powerset
    public static <T> Set<Set<T>> realPowerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<T> list = new ArrayList<>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<T> set : realPowerSet(rest)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static <T> Set<Set<T>> realPowerSet(List<T> originalSet) {
        return realPowerSet(new TreeSet<>(originalSet));
    }
}

