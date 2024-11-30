package com.schoolmgmt.schoolMgmt.controller;

import com.schoolmgmt.schoolMgmt.entity.Student;
import com.schoolmgmt.schoolMgmt.repo.StudentRepository;

import com.schoolmgmt.schoolMgmt.repo.UserDetailsDto;
import com.schoolmgmt.schoolMgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@EnableCaching
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    @Cacheable(value = "students", key = "#root.methodName")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/saveStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }



    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
