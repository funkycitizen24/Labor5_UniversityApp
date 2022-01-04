import model.Course;
import model.Student;
import model.Teacher;
import repository.CourseRepository;
import repository.EnrolledRepository;
import repository.StudentRepository;
import repository.TeacherRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final EnrolledRepository enrolledRepository;

    public RegistrationSystem(CourseRepository courseRepository1, StudentRepository studentRepository1, TeacherRepository teacherRepository1, EnrolledRepository enrolledRepository) {
        this.courseRepository = courseRepository1;
        this.studentRepository = studentRepository1;
        this.teacherRepository = teacherRepository1;
        this.enrolledRepository = enrolledRepository;
    }


    public TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public EnrolledRepository getEnrolledRepository() {
        return enrolledRepository;
    }

    /**
     * @param student is an object type Student
     * @param course  is an object type Course
     * @return true if the student is successfully enrolled in course
     */
    public boolean register(Student student, Course course) throws SQLException {
        if (courseRepository.findOne(course.getCourseId()).getCourseId() == 0 && studentRepository.findOne(student.getStudentId()).getStudentId() == 0) {
            System.out.println("Either the course or the student don't exist");
            return false;
        }
        if (enrolledRepository.findOne(student.getStudentId(), course.getCourseId())) {
            System.out.println("You are already registered");
            return false;
        }
        if (retrieveStudentsFromCourse(course).size() + 1 > course.getMaxEnrollment()) {
            System.out.println("There are no free places");
            return false;
        }
        if (course.getCredits() + student.getTotalCredits() > 30) {
            System.out.println("Your credits exceed the limit of 30");
            return false;
        }


        student.setTotalCredits(student.getTotalCredits() + course.getCredits());//update credits
        studentRepository.update(student);
        enrolledRepository.save(student.getStudentId(), course.getCourseId());
        System.out.println("Successfully registered");
        return true;


    }


    /**
     * @return the list of courses with free places
     */
    public List<Course> retrieveCoursesWithFreePlaces() throws SQLException {
        List<Course> coursesWithFreePlaces = new ArrayList<>();
        for (Course course : courseRepository.findAll())
            if (course.getMaxEnrollment() > enrolledRepository.findStudentsByCourse(course.getCourseId()).size())
                coursesWithFreePlaces.add(course);
        return coursesWithFreePlaces;
    }

    /**
     * @param course is a course
     * @return the list of students attending the specified course
     */
    public List<Student> retrieveStudentsFromCourse(Course course) throws SQLException {
        return enrolledRepository.findStudentsByCourse(course.getCourseId());

    }

    /**
     * @return a list of all courses
     */
    public List<Course> getAllCourses() throws SQLException {
        return (ArrayList<Course>) courseRepository.findAll();
    }

    /**
     * updates the credits of a course
     * updates the number of credits of student enrolled in that course
     *
     * @param course  is a course
     * @param credits is the new number of credits
     */
    public boolean updateCredits(Course course, int credits) throws SQLException {
        if (courseRepository.findOne(course.getCourseId()).getCourseId() == 0)
            return false;
        int difference = course.getCredits() - credits;
        for (Student s : retrieveStudentsFromCourse(course)) {
            s.setTotalCredits(s.getTotalCredits() - difference);
            studentRepository.update(s);
        }
        course.setCredits(credits);
        courseRepository.update(course);
        return true;
    }

    /**
     * Deletes the course
     *
     * @param course  is the course deleted
     * @param teacher is the teacher deleting the course
     */
    public boolean deleteCourse(Teacher teacher, Course course) throws SQLException {
        if (teacherRepository.findOne(teacher.getTeacherId()).getTeacherId() == 0 || courseRepository.findOne(course.getCourseId()).getCourseId() == 0)
            return false;
        for (Student s : retrieveStudentsFromCourse(course)) {
            s.setTotalCredits(s.getTotalCredits() - course.getCredits());
            studentRepository.update(s);
        }
        enrolledRepository.deleteByCourse(course.getCourseId());
        courseRepository.delete(course.getCourseId());
        return true;

    }

}