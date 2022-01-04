package view;

import model.Teacher;

public class TeacherView {
    /**
     * This method prints the details of the teacher.
     * @param teacher Teacher
     */
    public void printTeacherDetails(Teacher teacher){
        System.out.println("Teacher: ");
        System.out.println("First name: " + teacher.getFirstName());
        System.out.println("Last name: " + teacher.getLastName());
        System.out.println("Id: " + teacher.getTeacherId());
        System.out.print("Courses: ");
        if (teacher.getCourses().isEmpty())
            System.out.println("no courses");
        else {
            //to show every course's name, not the course object
            for (int i = 0; i < teacher.getCourses().size() - 1; i++)
                System.out.print(teacher.getCourses().get(i).getName() + ", ");
            //last course without "," after it
            System.out.print(teacher.getCourses().get(teacher.getCourses().size() - 1).getName());
        }
        System.out.println("\n");
    }
}