package com.examples.studentapi.rest;

import com.examples.studentapi.dto.StudentDTO;
import com.examples.studentapi.dto.StudentGradeDTO;
import com.examples.studentapi.service.StudentGradeService;
import com.examples.studentapi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;
    private final StudentGradeService studentGradeService;

    @Autowired
    public StudentController(StudentService studentService, StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/{id}/grades")
    public List<StudentGradeDTO> getGradesByStudent(@PathVariable Long id) {
        return studentGradeService.getGradesByStudentId(id);
    }
}
