package com.org.demo.controllers;

import com.org.demo.model.Student;
import com.org.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StrudentController {

    private final StudentService studentService;

    @Autowired
    public StrudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping (path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping (path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
        @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);
    }

}
