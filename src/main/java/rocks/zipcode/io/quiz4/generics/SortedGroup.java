package rocks.zipcode.io.quiz4.generics;

/**
 * @author leon on 18/12/2018.
 */
public class SortedGroup<T> extends Group<T> {
    @Override
    public void insert(T value) {
        list.add(value);
        list.sort(null);
    }

    @Override
    public void delete(T value) {
        list.remove(value);
    }

    public Integer indexOf(T value) {
        return list.indexOf(value);
    }
}
