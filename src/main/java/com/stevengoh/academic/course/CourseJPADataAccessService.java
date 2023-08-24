package com.stevengoh.academic.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaCourse")
@AllArgsConstructor
public class CourseJPADataAccessService implements  CourseDAO {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> selectAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> selectCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Optional<Course> selectCourseByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }

    @Override
    public boolean existsCourseByCourseCode(String courseCode) {
        return courseRepository.existsByCourseCode(courseCode);
    }

    @Override
    public boolean existsCourseById(Long courseId) {
        return courseRepository.existsById(courseId);
    }

    @Override
    public void insertCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void updateCourse(Course update) {
        courseRepository.save(update);
    }
}
