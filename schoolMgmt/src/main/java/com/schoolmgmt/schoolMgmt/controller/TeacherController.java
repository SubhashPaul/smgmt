package com.schoolmgmt.schoolMgmt.controller;

import com.schoolmgmt.schoolMgmt.entity.Teacher;
import com.schoolmgmt.schoolMgmt.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAllStudents() {
        return teacherRepository.findAll();
    }

    @PostMapping
    public Teacher addStudent(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getStudent(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Teacher updateStudent(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }
}
