package com.dkim.manager.controller;

import com.dkim.manager.model.Student;
import com.dkim.manager.repository.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/student")
public class StudentController {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @PutMapping("{id}")
    public Student updateStudent(
            @PathVariable("id") Student studentFromDb,
            @RequestBody Student studentFromUser
    ) {
        BeanUtils.copyProperties(studentFromUser, studentFromDb, "id");
        return studentRepo.save(studentFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Student student) {
        studentRepo.delete(student);
    }
}
