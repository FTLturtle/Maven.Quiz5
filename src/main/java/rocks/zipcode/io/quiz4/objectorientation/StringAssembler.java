package rocks.zipcode.io.quiz4.objectorientation;

/**
 * @author leon on 11/12/2018.
 */
public class StringAssembler {
    private Character delimiter;
    private StringBuilder stringBuilder;

    public StringAssembler(Character delimeter) {
        this.delimiter = delimeter;
        stringBuilder = new StringBuilder();
    }

    public StringAssembler append(String str) {
        if (stringBuilder.length() == 0) {
            stringBuilder.append(str);
        } else {
            stringBuilder.append(delimiter).append(str);
        }
        return this;
    }

    public String assemble() {
        return stringBuilder.toString();
    }
}
