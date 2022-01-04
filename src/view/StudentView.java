package view;

import model.Student;

public class StudentView {
    /**
     * This method prints the details of the student.
     * @param student Student
     */
    public void printStudentDetails(Student student){
        System.out.println("Student: ");
        System.out.println("First name: " + student.getFirstName());
        System.out.println("Last name: " + student.getLastName());
        System.out.println("Id: " + student.getStudentId());
        System.out.println("Total credits: " + student.getTotalCredits());
        System.out.print("Enrolled courses: ");
        if (student.getEnrolledCourses().isEmpty())
            System.out.println("no courses");
        else {
            //to show every course's name, not the course object
            for (int i = 0; i < student.getEnrolledCourses().size() - 1; i++)
                System.out.print(student.getEnrolledCourses().get(i).getName() + ", ");
            //last course without "," after it
            System.out.print(student.getEnrolledCourses().get(student.getEnrolledCourses().size() - 1).getName());
        }
        System.out.println("\n");
    }
}