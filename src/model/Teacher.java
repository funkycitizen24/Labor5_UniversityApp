package model;

import java.util.List;

public class Teacher extends Person{
    private long teacherId;
    private List<Course> courses;

    //Constructor
    public Teacher(String firstName, String lastName,long teacherId, List<Course> courses) {
        super(firstName, lastName);
        this.teacherId = teacherId;
        this.courses = courses;
    }

    //Getter for teacherId
    public long getTeacherId() {
        return teacherId;
    }

    //Setter for teacherId
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    //Getter for courses
    public List<Course> getCourses() {
        return courses;
    }

    //Setter for courses
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}