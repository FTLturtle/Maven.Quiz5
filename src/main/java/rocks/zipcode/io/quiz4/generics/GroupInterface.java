package rocks.zipcode.io.quiz4.generics;

/**
 * @author leon on 18/12/2018.
 */
public interface GroupInterface<T> extends Iterable<T> {
    Integer count();
    Boolean has(T valueToInsert);
    T fetch(int indexOfValue);
    void insert(T string);
    void delete(T valueToInsert);
    void clear();
}
