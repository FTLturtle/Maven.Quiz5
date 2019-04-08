package rocks.zipcode.io.quiz4.collections;

import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class ZipCodeWilmington {
    private List<Student> students;

    public ZipCodeWilmington() {
        students = new ArrayList<>();
    }

    public void enroll(Student student) {
        students.add(student);
    }

    public Boolean isEnrolled(Student student) {
        return students.contains(student);
    }

    public void lecture(double numberOfHours) {
        for (int i = 0; i < students.size(); i++) {
            students.get(i).learn(numberOfHours);
        }
    }

    public Map<Student, Double> getStudyMap() {
        Map<Student, Double> studentStudyMap = new TreeMap<>();
        for (Student student : students) {
            studentStudyMap.put(student, student.getTotalStudyTime());
        }
        return studentStudyMap;
    }
}
