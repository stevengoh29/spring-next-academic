package com.stevengoh.academic.student;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.util.List;

public record StudentDTO (
        Long id,
        String firstName,
        String lastName,
        LocalDate dob,
        String username,
        Boolean isEnabled,
        Boolean isLocked,
        List<String> appUserRole
) {

}
