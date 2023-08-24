package com.stevengoh.academic.auth;

import com.stevengoh.academic.student.StudentDTO;

public record AuthenticationResponse (
        String token,
        StudentDTO studentDTO
) {
}
