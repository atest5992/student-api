package com.examples.studentapi.common.converter;

import com.examples.studentapi.dao.entity.StudentGradeDO;
import com.examples.studentapi.dto.StudentGradeDTO;

import java.util.List;

public class StudentGradeConverter implements AbstractConverter<StudentGradeDTO, StudentGradeDO> {

    @Override
    public StudentGradeDTO doToDto(StudentGradeDO studentGradeDO) {
        return StudentGradeDTO.builder()
            .grade(studentGradeDO.getGrade())
            .description(studentGradeDO.getDescription())
            .gradeDate(studentGradeDO.getGradeDate())
            .build();
    }

    @Override
    public StudentGradeDO dtoToDo(StudentGradeDTO studentGradeDTO) {
        return StudentGradeDO.builder()
            .grade(studentGradeDTO.getGrade())
            .gradeDate(studentGradeDTO.getGradeDate())
            .description(studentGradeDTO.getDescription())
            .build();
    }

    @Override
    public List<StudentGradeDTO> doToDto(List<StudentGradeDO> dos) {
        return null;
    }

    @Override
    public List<StudentGradeDO> dtoToDo(List<StudentGradeDTO> dos) {
        return null;
    }
}
