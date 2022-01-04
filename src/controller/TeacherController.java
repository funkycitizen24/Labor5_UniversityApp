package controller;

import model.Course;
import model.Teacher;
import view.TeacherView;

import java.util.List;

public class TeacherController {
    private Teacher model;
    private TeacherView view;

    //Constructor
    public TeacherController(Teacher model, TeacherView view){
        this.model = model;
        this.view = view;
    }

    //Getters and Setters

    public String getTeacherFirstName(){
        return model.getFirstName();
    }

    public void setTeacherFirstName(String firstName){
        model.setFirstName(firstName);
    }

    public String getTeacherLastName(){
        return model.getLastName();
    }

    public void setTeacherLastName(String lastName){
        model.setLastName(lastName);
    }

    public long getTeacherTeacherId() {
        return model.getTeacherId();
    }

    public void setTeacherTeacherId(long teacherId) {
        model.setTeacherId(teacherId);
    }

    public List<Course> getTeacherCourses() {
        return model.getCourses();
    }

    public void setTeacherCourses(List<Course> courses) {
        model.setCourses(courses);
    }

    //Teacher's details
    public void updateView(){
        view.printTeacherDetails(model);
    }
}
