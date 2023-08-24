package com.stevengoh.academic.student;

import com.stevengoh.academic.security.PasswordEncoder;
import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentDAO studentDAO;
    private final CustomResponse<?> customResponse;
    private final StudentDTOMapper studentDTOMapper;

    public List<StudentDTO> getStudents() {
            List<Student> studentList = studentDAO.selectAllStudents();
            return studentList.stream().map(studentDTOMapper).collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long studentId) {
        final String ERR_STUDENT_NOT_FOUND = "Student with id %s does not exist";

        Optional<Student> student = studentDAO.selectStudentById(studentId);
        if(student.isEmpty()) throw new IllegalStateException(String.format(ERR_STUDENT_NOT_FOUND, studentId));

        Student stu = student.get();

        return new StudentDTO(stu.getId(), stu.getFirstName(), stu.getLastName(), stu.getDob(), stu.getUsername(), stu.isEnabled(), stu.getIsLocked(), stu.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    }

    public String registerStudent(StudentRequest studentRequest) {
        final String ERR_REGISTER_STUDENT = "Username %s has already been used";

        Optional<Student> student = studentDAO.selectUserByEmail(studentRequest.getUsername());

        if(student.isPresent()) throw new IllegalStateException(String.format(ERR_REGISTER_STUDENT, studentRequest.getUsername()));

        final PasswordEncoder passwordEncoder = new PasswordEncoder();

        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(studentRequest.getPassword());

        Student newStudent = new Student(studentRequest.getFirstName(), studentRequest.getLastName(), studentRequest.getDob(), studentRequest.getUsername(), encodedPassword);

        studentDAO.insertStudent(newStudent);

        return "Insert successfully";
    }

    public StudentDTO getStudentByEmail(String email) {
        final String ERR_STUDENT_NOT_FOUND = "Email %s does not exist";

        Optional<Student> student = studentDAO.selectUserByEmail(email);
        if(student.isEmpty()) throw new IllegalStateException(String.format(ERR_STUDENT_NOT_FOUND, email));

        Student stu = student.get();

        return new StudentDTO(stu.getId(), stu.getFirstName(), stu.getLastName(), stu.getDob(), stu.getUsername(), stu.isEnabled(), stu.getIsLocked(), stu.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    }
}
