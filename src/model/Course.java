package model;

import java.util.List;

public class Course {
    private long courseId;
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    //Constructor
    public Course(String name, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits, long courseId) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
        this.courseId = courseId;
    }

    //Getter for courseId
    public long getCourseId() {
        return courseId;
    }

    //Setter for courseId
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for teacher
    public Person getTeacher() {
        return teacher;
    }

    //Setter for teacher
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    //Getter for maxEnrollment
    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    //Setter for maxEnrollment
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    //Getter for studentsEnrolled
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    //Setter for studentsEnrolled
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    //Getter for credits
    public int getCredits() {
        return credits;
    }

    //Setter for credits
    public void setCredits(int credits) {
        this.credits = credits;
    }
}
