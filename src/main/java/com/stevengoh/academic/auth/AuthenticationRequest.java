package com.stevengoh.academic.auth;

public record AuthenticationRequest (
        String username,
        String password
) {
}
