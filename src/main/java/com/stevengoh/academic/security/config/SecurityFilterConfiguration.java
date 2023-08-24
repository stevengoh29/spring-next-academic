package com.stevengoh.academic.security.config;

import com.stevengoh.academic.security.jwt.AuthEntryPointJwt;
import com.stevengoh.academic.security.jwt.AuthTokenFilter;
import com.stevengoh.academic.student.StudentUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityFilterConfiguration {
    private final StudentUserDetailsService studentUserDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authTokenFilter () {
        return new AuthTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder2 () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(studentUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder2());

        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain  securityFilterChain (HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/student").permitAll()
                                .requestMatchers("/error").permitAll()
                                .anyRequest().authenticated()
                )
                .addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }




//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(HttpMethod.POST, "/api/v1/**").permitAll()
////                        .requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
////                        .anyRequest().authenticated()
////                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
//                .build();
//
//
////        http
////                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/api/v1/**").permitAll()
////                )
////                .formLogin(Customizer.withDefaults());
////        return http.build();
////        http
////                .csrf(AbstractHttpConfigurer::disable)
////                .cors(Customizer.withDefaults())
////                .authorizeHttpRequests(auth -> auth.requestMatchers(
////                                HttpMethod.POST,
////                                "/api/v1/**",
////                                "/api/v1/auth/login"
////                        )
////                        .permitAll()
////                        .requestMatchers(
////                                HttpMethod.GET,
////                                "/ping"
////                        )
////                        .permitAll()
////                        .requestMatchers(HttpMethod.GET, "/actuator/**")
////                        .permitAll()
////                        .anyRequest()
////                        .authenticated()
////                        )
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .authenticationProvider(authenticationProvider)
////                .addFilterBefore(
////                        jwtAuthenticationFilter,
////                        UsernamePasswordAuthenticationFilter.class
////                );
//////                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
////
////        return http.build();
//    }
}
