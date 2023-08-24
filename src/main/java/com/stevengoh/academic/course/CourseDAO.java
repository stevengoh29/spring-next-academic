package com.stevengoh.academic.course;

import com.stevengoh.academic.course.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDAO {
    List<Course> selectAllCourses();
    Optional<Course> selectCourseById(Long courseId);
    Optional<Course> selectCourseByCourseCode(String email);
    boolean existsCourseByCourseCode(String courseCode);
    boolean existsCourseById(Long courseId);
    void insertCourse(Course course);
    void deleteCourseById(Long courseId);
    void updateCourse(Course update);
}
