package com.stevengoh.academic.course;

import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<CustomResponse<?>> getCourses () {
        return courseService.getCourses();
    }

    @PostMapping
    public ResponseEntity<CustomResponse<?>> registerCourse (@RequestBody CourseRequest requestBody) {
        return courseService.registerCourse(requestBody);
    }

    public void getCoursesByCode(String courseCode) {

    }

}
