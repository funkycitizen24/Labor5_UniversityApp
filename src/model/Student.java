package model;

import java.util.List;

public class Student extends Person{
    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    //Constructor
    public Student(String firstName, String lastName, long studentId, int totalCredits, List<Course> enrolledCourses) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    //Getter for studentId
    public long getStudentId() {
        return studentId;
    }

    //Setter for studentId
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    //Getter for totalCredits
    public int getTotalCredits() {
        return totalCredits;
    }

    //Setter for totalCredits
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    //Getter for enrolledCourses
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    //Setter for enrolledCourses
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}