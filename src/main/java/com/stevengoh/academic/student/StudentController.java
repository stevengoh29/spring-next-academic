package com.stevengoh.academic.student;

import com.stevengoh.academic.utils.CustomResponse;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CustomResponse<?> customResponse;

    @GetMapping
    public ResponseEntity<?> getStudents (@RequestParam(name = "studentId", required = false) Long studentId, @RequestParam(name = "email", required = false) String email) {
        if(studentId == null && StringUtils.isBlank(email)) {
            List<StudentDTO> studentList = studentService.getStudents();
            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Student Data fetched", studentList));
        }

        if(studentId != null) {
            StudentDTO student = studentService.getStudentById(studentId);

            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Student By Id fetched", student));
        }

        if(StringUtils.isNotBlank(email)) {
            StudentDTO student = studentService.getStudentByEmail(email);

            return ResponseEntity.ok(customResponse.setCustomResponse(200, "Student By email fetched", student));
        }

        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<CustomResponse<?>> registerStudent (@RequestBody StudentRequest studentRequest) {
        String result = studentService.registerStudent(studentRequest);

        return ResponseEntity.ok(customResponse.setCustomResponse(200, result));
    }
}
