package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // Add student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s) {
        return repo.save(s);
    }

    // Get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    // Get student by ID
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // Update student
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student s) {
        s.setId(id);
        return repo.save(s);
    }

    // Delete student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }
}