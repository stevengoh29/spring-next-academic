package com.stevengoh.academic.course;

import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CustomResponse<?> customResponse;
    public ResponseEntity<CustomResponse<?>> getCourses() {
        List<Course> courses = courseRepository.findAll();

        if(courses.isEmpty()) return ResponseEntity.ok(customResponse.setCustomResponse(200, "Courses not found", null));

        return ResponseEntity.ok(customResponse.setCustomResponse(200, "Courses not found", courses));
    }

    public ResponseEntity<CustomResponse<?>> registerCourse(CourseRequest requestBody) {
        boolean courseIsExists = courseRepository.existsByCourseCode(requestBody.getCourseCode());

        if(courseIsExists) throw new IllegalStateException(("Course already exists"));

        Course newCourse = new Course(requestBody.getCourseCode(), requestBody.getCourseName(), requestBody.getCourseDescription(), requestBody.getIsActive(), requestBody.getCourseCredit());

        courseRepository.save(newCourse);

        return ResponseEntity.ok(customResponse.setCustomResponse(200, "Course inserted successfully"));
    }
}
