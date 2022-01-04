package repository;

import model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository implements ICrudRepository<Student>{
    private List<Student> studentList;

    //Constructor


    public StudentRepository() {
        this.studentList = studentList;
    }

    //Getter for studentList
    public List<Student> getstudentList() {
        return studentList;
    }

    //Setter for studentList
    public void setstudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * @param id -the id of the student to be returned; id must not be null
     * @return the student with the specified id or null - if there is no student with the given id
     */
    @Override
    public Student findOne(Long id) {
        for(Student student: studentList) {
            if (student.getStudentId() == id)
                return student;
        }
        return null;
    }

    /**
     * @return all students
     */
    @Override
    public Iterable<Student> findAll() {
        return studentList;
    }

    /**
     * @param entity must be not null
     * @return null- if the given student is saved otherwise returns the student(id already exists)
     */
    @Override
    public Student save(Student entity) {
        if(findOne(entity.getStudentId())==null)
            studentList.add(entity);
        else
            return entity;

        return null;
    }

    /**
     * removes the student with the specified id
     *
     * @param id id must be not null
     * @return the removed student or null if there is no student with the given id
     */
    @Override
    public Student delete(Long id) {
        Student tempStudent; //temporary student for return after remove
        for(Student student: studentList) {
            if (student.getStudentId() == id)
            {
                tempStudent=student;
                studentList.remove(student);
                return tempStudent;
            }
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Student update(Student entity) {
        for(Student student: studentList) {
            if (student.getStudentId() == entity.getStudentId()) {
                student.setTotalCredits(entity.getTotalCredits());
                student.setEnrolledCourses(entity.getEnrolledCourses());
                student.setLastName(entity.getLastName());
                student.setFirstName(entity.getFirstName());
                return null;
            }
        }
        return entity;
    }

    /**
     *
     * @return the list of students sorted alphabetically
     */
    public List<Student> sort(){
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param length
     * @return the student list filtered by the first name length
     */

    public List<Student> filter(int length){
        return studentList.stream()
                .filter(str -> str.getFirstName().length() > length)
                .collect(Collectors.toList());
    }
}
