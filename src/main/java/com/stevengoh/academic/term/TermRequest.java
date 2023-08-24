package com.stevengoh.academic.term;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TermRequest {
    private final String termCode;
    private final Boolean isActive;
}
