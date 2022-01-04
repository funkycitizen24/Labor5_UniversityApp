package controller;

import model.Course;
import model.Student;
import view.StudentView;

import java.util.List;

public class StudentController {
    private Student model;
    private StudentView view;

    //Constructor
    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    //Getters and Setters

    public String getStudentFirstName(){
        return model.getFirstName();
    }

    public void setStudentFirstName(String firstName){
        model.setFirstName(firstName);
    }

    public String getStudentLastName(){
        return model.getLastName();
    }

    public void setStudentLastName(String lastName){
        model.setLastName(lastName);
    }

    public long getStudentStudentId() {
        return model.getStudentId();
    }

    public void setStudentStudentId(long studentId) {
        model.setStudentId(studentId);
    }

    public int getStudentTotalCredits() {
        return model.getTotalCredits();
    }

    public void setStudentTotalCredits(int totalCredits) {
        model.setTotalCredits(totalCredits);
    }

    public List<Course> getStudentEnrolledCourses() {
        return model.getEnrolledCourses();
    }

    public void setStudentEnrolledCourses(List<Course> enrolledCourses) {
        model.setEnrolledCourses(enrolledCourses);
    }

    //Student's details
    public void updateView(){
        view.printStudentDetails(model);
    }
}