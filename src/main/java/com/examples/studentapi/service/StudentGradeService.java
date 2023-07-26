package com.examples.studentapi.service;

import com.examples.studentapi.dto.StudentGradeDTO;

import java.util.List;

public interface StudentGradeService extends AbstractService {

    StudentGradeDTO saveGrade(StudentGradeDTO studentGradeDTO);
    List<StudentGradeDTO> getGradesByStudentId(Long studentId);
    StudentGradeDTO getById(Long id);
}
