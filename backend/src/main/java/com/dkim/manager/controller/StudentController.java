package com.dkim.manager.controller;

import com.dkim.manager.model.Student;
import com.dkim.manager.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("{id}")
    public Student updateStudent(
            @PathVariable("id") Student studentFromDb,
            @RequestBody Student studentFromUser
    ) {
        BeanUtils.copyProperties(studentFromUser, studentFromDb, "id");
        return studentService.addStudent(studentFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Student student) {
        studentService.deleteStudent(student);
    }
}
