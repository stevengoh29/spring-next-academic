package com.stevengoh.academic.score;

import com.stevengoh.academic.course.Course;
import com.stevengoh.academic.student.Student;
import com.stevengoh.academic.term.Term;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Score {
    @Id
    @SequenceGenerator(name = "score_seq", sequenceName = "score_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq")
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(nullable = false, name = "term_id")
    private Term term;

    @OneToOne
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    private Long score;

    public Score(Student student, Term term, Course course, Long score) {
        this.student = student;
        this.term = term;
        this.course = course;
        this.score = score;
    }
}
