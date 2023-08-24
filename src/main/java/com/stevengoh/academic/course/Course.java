package com.stevengoh.academic.course;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor

@Getter
public class Course {
    @Id
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    private Long id;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private Boolean isActive;
    private Integer courseCredit;

    public Course(String courseCode, String courseName, String courseDescription, Boolean isActive, Integer courseCredit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.isActive = isActive;
        this.courseCredit = courseCredit;
    }
}
