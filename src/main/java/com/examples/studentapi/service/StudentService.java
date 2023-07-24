package com.examples.studentapi.service;

import com.examples.studentapi.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);
    List<StudentDTO> findAll();
    StudentDTO getById(Long id);
}
