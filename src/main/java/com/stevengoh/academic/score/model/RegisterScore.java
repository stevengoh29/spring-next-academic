package com.stevengoh.academic.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RegisterScore {
    private final String username;
    private final String courseCode;
    private final String termCode;
    private final Long score;
}
