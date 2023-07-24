package com.examples.studentapi.rest;

import com.examples.studentapi.dto.StudentDTO;
import com.examples.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }


    @PostMapping
    public StudentDTO save(@RequestParam StudentDTO studentDTO) {
        return service.save(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
