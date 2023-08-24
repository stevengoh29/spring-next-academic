package com.stevengoh.academic.course;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CourseRequest {
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private Boolean isActive;
    private Integer courseCredit;
}
