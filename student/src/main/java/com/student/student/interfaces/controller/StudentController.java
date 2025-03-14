package com.student.student.interfaces.controller;

import com.student.student.interfaces.dto.StudentResponse;
import com.student.student.domain.model.Student;
import com.student.student.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
    private final  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable String id){
        return studentService.fetchStudentById(id);
    }

    @GetMapping
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }

    @GetMapping("/without-school")
    public List<StudentResponse> getStudentsWithoutSchool() {
        return studentService.getStudentsWithoutSchool();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

}
