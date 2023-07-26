package com.examples.studentapi.rest;

import com.examples.studentapi.dto.StudentGradeDTO;
import com.examples.studentapi.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("grades")
public class StudentGradeController {

    private final StudentGradeService studentGradeService;

    @Autowired
    public StudentGradeController(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @PostMapping
    public StudentGradeDTO getById(@RequestBody StudentGradeDTO studentGradeDTO) {
        return studentGradeService.saveGrade(studentGradeDTO);
    }

    @GetMapping("/{id}")
    public StudentGradeDTO getById(@PathVariable Long id) {
        return studentGradeService.getById(id);
    }
}