package com.examples.studentapi.common.converter;

import com.examples.studentapi.dao.entity.StudentGradeDO;
import com.examples.studentapi.dto.StudentGradeDTO;
import com.examples.studentapi.util.DateConverter;

import java.util.List;

public class StudentGradeConverter implements AbstractConverter<StudentGradeDTO, StudentGradeDO> {

    @Override
    public StudentGradeDTO doToDto(StudentGradeDO studentGradeDO) {
        return StudentGradeDTO.builder()
            .id(studentGradeDO.getId())
            .grade(studentGradeDO.getGrade())
            .description(studentGradeDO.getDescription())
            .studentId(studentGradeDO.getStudentId().getId())
            .gradeDate(studentGradeDO.getGradeDate().toString())
            .build();
    }

    @Override
    public StudentGradeDO dtoToDo(StudentGradeDTO studentGradeDTO) {
        return StudentGradeDO.builder()
            .grade(studentGradeDTO.getGrade())
            .gradeDate(DateConverter.convertDate(studentGradeDTO.getGradeDate()))
            .description(studentGradeDTO.getDescription())
            .build();
    }

    @Override
    public List<StudentGradeDTO> doToDto(List<StudentGradeDO> dos) {
        return dos.stream().map(this::doToDto).toList();
    }

    @Override
    public List<StudentGradeDO> dtoToDo(List<StudentGradeDTO> dtos) {
        return dtos.stream().map(this::dtoToDo).toList();
    }
}
