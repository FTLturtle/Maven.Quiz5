package rocks.zipcode.io.quiz4.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author leon on 11/12/2018.
 */
public class ComparableTreeSet<T extends Comparable<T>> extends TreeSet<T> implements Comparable<ComparableTreeSet<T>>{

    @SafeVarargs
    public ComparableTreeSet(T... arr) {
        super(Arrays.asList(arr));
    }


    public ComparableTreeSet() {
        super();
    }


    @Override
    public int compareTo(ComparableTreeSet<T> o) {
        ListComparator<T> listComparator = new ListComparator<>();
        return listComparator.compare(new ArrayList<>(this), new ArrayList<>(o));
    }
}
