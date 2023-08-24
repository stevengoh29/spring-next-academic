package com.stevengoh.academic.auth;

import com.stevengoh.academic.security.jwt.JwtUtils;
import com.stevengoh.academic.student.Student;
import com.stevengoh.academic.student.StudentDTO;
import com.stevengoh.academic.student.StudentDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final StudentDTOMapper studentDTOMapper;

    public AuthenticationResponse login (AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.issueJWTToken(authentication);

        Student principal = (Student) authentication.getPrincipal();
        StudentDTO studentDTO = studentDTOMapper.apply(principal);

        return new AuthenticationResponse(jwtToken, studentDTO);
    }
}
