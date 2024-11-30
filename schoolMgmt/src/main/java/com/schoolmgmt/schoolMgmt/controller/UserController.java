package com.schoolmgmt.schoolMgmt.controller;

import com.schoolmgmt.schoolMgmt.repo.StudentRepository;
import com.schoolmgmt.schoolMgmt.repo.UserDetailsDto;
import com.schoolmgmt.schoolMgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> addStudent(@RequestBody UserDetailsDto userDetailsDto) {
        String result= userService.saveUser(userDetailsDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        return ResponseEntity.ok(response);



    }
}
