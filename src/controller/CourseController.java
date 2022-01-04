package controller;

import model.Course;
import model.Person;
import model.Student;
import view.CourseView;

import java.util.List;

public class CourseController {
    private Course mod;
    private CourseView view;

    //Constructor
    public CourseController(Course mod, CourseView view){
        this.mod = mod;
        this.view = view;
    }

    //Getters and Setters

    public long getCourseCourseId(){
        return mod.getCourseId();
    }

    public void setCourseCourseId(long courseId){
        mod.setCourseId(courseId);
    }

    public String getCourseName(){
        return mod.getName();
    }

    public void setCourseName(String name){
        mod.setName(name);
    }

    public Person getCourseTeacher() {
        return mod.getTeacher();
    }

    public void setCourseTeacher(Person teacher) {
        mod.setTeacher(teacher);
    }

    public int getCourseMaxEnrollment() {
        return mod.getMaxEnrollment();
    }

    public void setCourseMaxEnrollment(int maxEnrollment) {
        mod.setMaxEnrollment(maxEnrollment);
    }

    public List<Student> getCourseStudentsEnrolled() {
        return mod.getStudentsEnrolled();
    }

    public void setCourseStudentsEnrolled(List<Student> studentsEnrolled) {
        mod.setStudentsEnrolled(studentsEnrolled);
    }

    public int getCourseCredits() {
        return mod.getCredits();
    }

    public void setCourseCredits(int credits) {
        mod.setCredits(credits);
    }

//    //Course's details
//    public void updateView(){
//        view.printCourseDetails(mod);
//    }
}