package view;

import model.Course;

public class CourseView {
    /**
     * This method prints the details of the course.
     * @param course Course
     */
    public void printCourseDetails(Course course){
        System.out.println("Course: ");
        System.out.println("Id: " + course.getCourseId());
        System.out.println("Name: " + course.getName());
        System.out.println("Teacher: " + course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName());
        System.out.println("Maximum number of students enrolled: " + course.getMaxEnrollment());
        System.out.print("Students enrolled: ");
        if (course.getStudentsEnrolled().isEmpty())
            System.out.print("no students");
        else {
            //to show every student's name, not the student object
            for (int i = 0; i < course.getStudentsEnrolled().size() - 1; i++)
                System.out.print(course.getStudentsEnrolled().get(i).getFirstName() + " " + course.getStudentsEnrolled().get(i).getLastName() + ", ");
            //last student without "," after him/her
            System.out.print(course.getStudentsEnrolled().get(course.getStudentsEnrolled().size() - 1).getFirstName() + " " + course.getStudentsEnrolled().get(course.getStudentsEnrolled().size() - 1).getLastName());
        }
        System.out.println("\nCredits: " + course.getCredits() + "\n");
    }
}
