package com.examples.studentapi.service;

import com.examples.studentapi.common.converter.StudentConverter;
import com.examples.studentapi.dao.entity.StudentDO;
import com.examples.studentapi.dao.repository.StudentDAO;
import com.examples.studentapi.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.examples.studentapi.validator.EmailValidator.isValidEmail;
import static io.micrometer.common.util.StringUtils.isBlank;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final StudentConverter studentConverter = new StudentConverter();

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        validateStudent(studentDTO);

        StudentDO studentDO = studentConverter.dtoToDo(studentDTO);
        studentDO = studentDAO.save(studentDO);

        log.info("Generated student with id {}", studentDO.getId());
        return studentConverter.doToDto(studentDO);
    }

    private void validateStudent(StudentDTO studentDTO) {
        if (isNull(studentDTO) || isBlank(studentDTO.getEmail()) || !isValidEmail(studentDTO.getEmail())
            || isBlank(studentDTO.getPassword()) || nonNull(studentDTO.getId())) {
            throw new IllegalArgumentException("Student DTO is not valid.");
        }

        if (studentDAO.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Student is already registered.");
        }
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentConverter.doToDto(studentDAO.findAll());
    }

    @Override
    public StudentDTO getById(Long id) {
        checkId(id);

        final Optional<StudentDO> optionalStudentDO = studentDAO.findById(id);
        if (optionalStudentDO.isEmpty()) {
            throw new IllegalArgumentException("Student with id not found.");
        }

        return studentConverter.doToDto(optionalStudentDO.get());
    }

    private static void checkId(Long id) {
        if (isNull(id) || id <= 0) {
            throw new IllegalArgumentException("Invalid student id");
        }
    }
}
