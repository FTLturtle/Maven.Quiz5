package rocks.zipcode.io.quiz4.collections;

/**
 * @author leon on 11/12/2018.
 */
public class Student implements Comparable<Student>{
    private Integer id;
    private Double totalStudyTime;

    public Student() {
        this(null);
    }

    public Student(Integer id) {
        this.id = id;
        this.totalStudyTime = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void learn(Double amountOfHours) {
        totalStudyTime += amountOfHours;
    }

    public Double getTotalStudyTime() {
        return totalStudyTime;
    }

    @Override
    public int compareTo(Student o) {
        int result;
        if (this.id == null) {
            result = -1;
        } else {
            result = this.id.compareTo(o.getId());
        }
        return result;
    }
}
