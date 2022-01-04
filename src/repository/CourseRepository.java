package repository;

import model.Course;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository implements ICrudRepository<Course>{
    private List<Course> courseList;

    //Constructor
    public CourseRepository() {
        this.courseList = courseList;
    }

    //Getter for courseList
    public List<Course> getCourseList() {
        return courseList;
    }

    //Setter for teacherList
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * @param id -the id of the course to be returned; id must not be null
     * @return the course with the specified id or null - if there is no course with the given id
     */
    @Override
    public Course findOne(Long id) {
        for(Course course: courseList) {
            if (course.getCourseId() == id)
                return course;
        }
        return null;
    }

    /**
     * @return all courses
     */
    @Override
    public Iterable<Course> findAll() {
        return courseList;
    }

    /**
     * @param entity entity must be not null
     * @return null- if the given course is saved otherwise returns the course(id already exists)
     */
    @Override
    public Course save(Course entity) {
        if(findOne(entity.getCourseId())==null)
            courseList.add(entity);
        else
            return entity;

        return null;
    }

    /**
     * removes the course with the specified id
     *
     * @param id id must be not null
     * @return the removed course or null if there is no course with the given id
     */
    @Override
    public Course delete(Long id) {
        Course tempCourse; //temporary teacher for return after remove
        for(Course course: courseList) {
            if (course.getCourseId() == id)
            {
                tempCourse = course;
                courseList.remove(course);
                return tempCourse;
            }
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Course update(Course entity) {
        for(Course course: courseList) {
            if (course.getCourseId() == entity.getCourseId()) {
                course.setName(entity.getName());
                course.setStudentsEnrolled(entity.getStudentsEnrolled());
                course.setCredits(entity.getCredits());
                course.setMaxEnrollment(entity.getMaxEnrollment());
                course.setTeacher(entity.getTeacher());
                return null;
            }
        }
        return entity;
    }

    /**
     *
     * @return the courses sorted alphabetically by name
     */
    public List<Course> sort(){
        return courseList.stream()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param length
     * @return course list filtered by length of course name
     */
    public List<Course> filter(int length){
        return courseList.stream()
                .filter(str -> str.getName().length() > length)
                .collect(Collectors.toList());
    }


}
