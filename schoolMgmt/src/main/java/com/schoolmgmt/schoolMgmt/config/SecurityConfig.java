package com.schoolmgmt.schoolMgmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    //@Autowired
    //JwtAuthenticationFilter jwtAuthenticationFilter;
    //@Autowired
    //JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public UserDetailsService userDetailsService() {
//        System.out.println("userDetails Servicse");
        return new UserInfo();
//   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//   encoder.encode("monu");
//            UserDetails user = User.withUsername("user")
//                    .password(encoder.encode("user"))
//                    .roles("USER")
//                    .build();
////
////
//
//            UserDetails admin = User.withUsername("admin")
//                    .password(encoder.encode("admin"))
//                    .roles("ADMIN")
//                    .build();
//            return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Security Filter chain");

        http.csrf(csrf->csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(
                        auth->
                                auth.requestMatchers("/user/**").permitAll()
                                        .requestMatchers("/student/**").hasRole("STUDENT")
                                        .requestMatchers("/teacher/**").hasRole("TEACHER")
                                        .anyRequest().authenticated())
              //  .exceptionHandling(ex->ex.authenticationEntryPoint(entryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
      //  http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("authentication provider");
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    // Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}