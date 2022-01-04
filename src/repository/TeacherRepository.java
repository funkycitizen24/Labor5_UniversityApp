package repository;

import model.Course;
import model.Student;
import model.Teacher;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository implements ICrudRepository<Teacher>{

    private List<Teacher> teacherList;

    //Constructor
    public TeacherRepository() {
        this.teacherList = teacherList;
    }

    //Getter for teacherList
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    //Setter for teacherList
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * @param id -the id of the teacher to be returned; id must not be null
     * @return the teacher with the specified id or null - if there is no teacher with the given id
     */
    @Override
    public Teacher findOne(Long id) {
        for(Teacher teacher: teacherList) {
            if (teacher.getTeacherId() == id)
                return teacher;
        }
        return null;
    }

    /**
     * @return all teachers
     */
    @Override
    public Iterable<Teacher> findAll() {
        return teacherList;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given teacher is saved otherwise returns the teacher(id already exists)
     */
    @Override
    public Teacher save(Teacher entity) {
        if(findOne(entity.getTeacherId())==null)
            teacherList.add(entity);
        else
            return entity;

        return null;
    }

    /**
     * removes the teacher with the specified id
     *
     * @param id id must be not null
     * @return the removed teacher or null if there is no teacher with the given id
     */
    @Override
    public Teacher delete(Long id) {
        Teacher tempTeacher; //temporary teacher for return after remove
        for(Teacher teacher: teacherList) {
            if (teacher.getTeacherId() == id)
            {
                tempTeacher = teacher;
                teacherList.remove(teacher);
                return tempTeacher;
            }
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Teacher update(Teacher entity) {
        for(Teacher teacher: teacherList) {
            if (teacher.getTeacherId() == entity.getTeacherId()) {
                teacher.setFirstName(entity.getFirstName());
                teacher.setLastName(entity.getLastName());
                teacher.setCourses(entity.getCourses());
                return null;
            }
        }
        return entity;
    }

    /**
     * This method allows the teacher to remove one of his courses.
     *
     * @param course - Course
     * @param teacher - Teacher
     */
    public void deleteCourse(Course course, Teacher teacher){
        teacher.getCourses().remove(course); // teacher deletes a course

        // deletes the course for all the students who have it and sets the number of credits
        for (Student stud: course.getStudentsEnrolled()){
            if (stud.getEnrolledCourses().contains(course)) {
                stud.getEnrolledCourses().remove(course);
                stud.setTotalCredits(stud.getTotalCredits() - course.getCredits());
            }
        }
        course.getStudentsEnrolled().clear(); // it clears all students enrolled in the course
    }

    /**
     *
     * @return list of teachers sorted alphabetically by last name
     */
    public List<Teacher> sort(){
        return teacherList.stream()
                .sorted(Comparator.comparing(Teacher::getLastName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param length
     * @return list of teachers filtered by the first name length
     */
    public List<Teacher> filter(int length){
        return teacherList.stream()
                .filter(str -> str.getFirstName().length()> length)
                .collect(Collectors.toList());
    }
}
