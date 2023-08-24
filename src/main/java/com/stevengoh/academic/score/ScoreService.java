package com.stevengoh.academic.score;

import com.stevengoh.academic.course.Course;
import com.stevengoh.academic.course.CourseRepository;
import com.stevengoh.academic.score.model.RegisterScore;
import com.stevengoh.academic.student.Student;
import com.stevengoh.academic.student.StudentRepository;
import com.stevengoh.academic.student.StudentService;
import com.stevengoh.academic.term.Term;
import com.stevengoh.academic.term.TermRepository;
import com.stevengoh.academic.term.TermService;
import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;
    private final TermRepository termRepository;
    private final CourseRepository courseRepository;

    private final CustomResponse<?> customResponse;



//    public ResponseEntity<CustomResponse<?>> registerScoreByUsername(RegisterScore registerScore) {
//        Student student = studentRepository.findByUsername(registerScore.getUsername());
//        Term term = termRepository.findByTermCode(registerScore.getTermCode());
//        Course course = courseRepository.findByCourseCode(registerScore.getCourseCode());
//
//        if(student == null) throw new IllegalStateException("Student is not found");
//        if(term == null) throw new IllegalStateException("Term is not found");
//        if(course == null) throw new IllegalStateException("Course is not found");
//
//        Score scoreToSave = new Score(student, term, course, registerScore.getScore());
//
//        scoreRepository.save(scoreToSave);
//
//        return ResponseEntity.ok(customResponse.setCustomResponse(200, "Score inserted successfully"));
//    }

//    public ResponseEntity<CustomResponse<?>> getScoreByUsername(String username) {
//        Student student = studentRepository.findByUsername(username);
//        List<Score> score =  scoreRepository.findByStudent(student);
//
//        return ResponseEntity.ok(customResponse.setCustomResponse(200, "Data score fetched", score));
//    }
}
