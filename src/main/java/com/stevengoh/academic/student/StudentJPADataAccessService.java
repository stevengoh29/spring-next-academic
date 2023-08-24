package com.stevengoh.academic.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("studentJPA")
@AllArgsConstructor
public class StudentJPADataAccessService implements StudentDAO {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> selectStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public boolean existsStudentWithEmail(String email) {
        return studentRepository.existsStudentByEmail(email);
    }

    @Override
    public boolean existsStudentById(Long studentId) {
        return studentRepository.existsStudentById(studentId);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void updateStudent(Student update) {
        studentRepository.save(update);
    }

    @Override
    public Optional<Student> selectUserByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
