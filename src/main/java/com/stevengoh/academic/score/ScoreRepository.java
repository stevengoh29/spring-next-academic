package com.stevengoh.academic.score;

import com.stevengoh.academic.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByStudent(Student student);
    Score findByStudentId (Long studentId);
}
