package com.stevengoh.academic.student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    List<Student> selectAllStudents();
    Optional<Student> selectStudentById(Long customerId);
    void insertStudent(Student customer);
    boolean existsStudentWithEmail(String email);
    boolean existsStudentById(Long customerId);
    void deleteStudentById(Long customerId);
    void updateStudent(Student update);
    Optional<Student> selectUserByEmail(String email);
}
