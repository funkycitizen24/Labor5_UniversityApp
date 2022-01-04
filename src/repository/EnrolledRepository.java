package repository;

import database.DatabaseConnect;
import model.Course;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrolledRepository {
    static final String QUERY_FIND = "SELECT * FROM ENROLLED WHERE studentID = ? AND courseID = ?";
    static final String QUERY_FIND_COURSE = "SELECT * FROM ENROLLED WHERE courseID = ?";
    static final String QUERY_FIND_STUDENT = "SELECT * FROM ENROLLED WHERE studentID = ?";
    static final String QUERY_FIND_TEACHER = "SELECT * FROM ENROLLED WHERE teacherID = ?";
    static final String QUERY_INSERT = "INSERT INTO ENROLLED VALUES (?, ?)";
    static final String QUERY_DELETE_BY_COURSE = "DELETE FROM ENROLLED WHERE courseID= ?";
    static final String QUERY_DELETE_ALL = "TRUNCATE ENROLLED";
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final Connection connection;
    private ResultSet resultSet;


    public EnrolledRepository(CourseRepository courseRepository, StudentRepository studentRepository) throws SQLException {
        super();
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.connection = new DatabaseConnect().getConnection();
    }

    public boolean findOne(long studentID, long courseID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
        preparedStatement.setLong(1, studentID);
        preparedStatement.setLong(2, courseID);
        this.resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }
    public List<Student> findStudentsByCourse(long ID) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_COURSE);
        preparedStatement.setLong(1, ID);
        this.resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            studentList.add(studentRepository.findOne(resultSet.getLong("studentID")));
        }
        return studentList;
    }
    public List<Course> findCoursesByStudent(long ID) throws SQLException {
        List<Course> studentList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_STUDENT);
        preparedStatement.setLong(1, ID);
        this.resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            studentList.add(courseRepository.findOne(resultSet.getLong("courseID")));
        }
        return studentList;
    }

    public List<Course> findCoursesByTeacher(long ID) throws SQLException {
        List<Course> coursesList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_TEACHER);
        preparedStatement.setLong(1, ID);
        this.resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            coursesList.add(courseRepository.findOne(resultSet.getLong("teacherID")));
        }
        return coursesList;
    }

    public void save(long studentID, long courseID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
        if (courseRepository.findOne(courseID).getCourseId() != 0 || studentRepository.findOne(studentID).getStudentId() != 0) {
            if (!findOne(studentID, courseID)) {
                preparedStatement.setLong(1, studentID);
                preparedStatement.setLong(2, courseID);
                preparedStatement.executeUpdate();
            }
        }
    }

    public void deleteByCourse(long courseID) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_BY_COURSE);
        if(courseRepository.findOne(courseID).getCourseId() != 0)
        {
            preparedStatement.setLong(1,courseID);
            preparedStatement.executeUpdate();
        }


    }
    public void deleteAllEntries() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_ALL);
        preparedStatement.executeUpdate();

    }

}