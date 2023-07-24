package com.examples.studentapi.common.converter;

import com.examples.studentapi.dao.entity.StudentDO;
import com.examples.studentapi.dto.StudentDTO;

import java.util.List;

public class StudentConverter implements AbstractConverter<StudentDTO, StudentDO> {

    @Override
    public StudentDTO doToDto(StudentDO studentDO) {
        return StudentDTO.builder()
            .id(studentDO.getId())
            .email(studentDO.getEmail())
            .username(studentDO.getUsername())
            .build();
    }

    @Override
    public StudentDO dtoToDo(StudentDTO studentDTO) {
        return StudentDO.builder()
            .email(studentDTO.getEmail())
            .username(studentDTO.getUsername())
            .password(studentDTO.getPassword())
            .build();
    }

    @Override
    public List<StudentDTO> doToDto(List<StudentDO> dos) {
        return dos.stream().map(this::doToDto).toList();
    }

    @Override
    public List<StudentDO> dtoToDo(List<StudentDTO> dtos) {
        return dtos.stream().map(this::dtoToDo).toList();
    }
}
