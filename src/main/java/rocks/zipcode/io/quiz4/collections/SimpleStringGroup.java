package rocks.zipcode.io.quiz4.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author leon on 11/12/2018.
 */
public class SimpleStringGroup implements Iterable<String>{
    private List<String> strings;

    public SimpleStringGroup() {
        strings = new ArrayList<>();
    }

    public Integer count() {
        return strings.size();
    }

    public void insert(String string) {
        strings.add(string);
    }

    public Boolean has(String string) {
        return strings.contains(string);
    }

    public String fetch(int indexOfValue) {
        return strings.get(indexOfValue);
    }

    public void delete(String string) {
        strings.remove(string);
    }

    public void clear() {
        strings.clear();
    }

    @Override
    public Iterator<String> iterator() {
        return strings.iterator();
    }
}
