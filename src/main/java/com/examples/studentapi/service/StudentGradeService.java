package com.examples.studentapi.service;

import com.examples.studentapi.dto.StudentGradeDTO;

import java.util.List;

public interface StudentGradeService extends AbstractService {

    List<StudentGradeDTO> getGradesByStudentId(Long studentId);
    List<StudentGradeDTO> findAllStudentGrades();

    StudentGradeDTO addNote(Long gradeId, String note);
}
