package rocks.zipcode.io.quiz4.generics;

import java.util.List;

public class ListComparator<T extends Comparable<T>> implements java.util.Comparator<List<T>> {
    @Override
    public int compare(List<T> o1, List<T> o2) {
        if (o1.size() == 0 && o2.size() == 0) {
            return 0;
        }

        int result = 0;
        int count = 0;
        while (result == 0 && count < o1.size() && count < o2.size()) {
            result = o1.get(count).compareTo(o2.get(count));
            count++;
        }

        if (result == 0) {
            result = o2.size() - o1.size();
        }

        return result;
    }
}
