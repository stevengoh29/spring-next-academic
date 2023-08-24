package com.stevengoh.academic.student;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentUserDetailsService implements UserDetailsService {

    private final StudentDAO studentDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentDAO.selectUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
