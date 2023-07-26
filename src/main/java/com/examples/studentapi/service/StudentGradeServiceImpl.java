package com.examples.studentapi.service;

import com.examples.studentapi.common.converter.StudentGradeConverter;
import com.examples.studentapi.dao.entity.StudentDO;
import com.examples.studentapi.dao.entity.StudentGradeDO;
import com.examples.studentapi.dao.repository.StudentGradeDAO;
import com.examples.studentapi.dao.repository.StudentDAO;
import com.examples.studentapi.dto.StudentGradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    private final StudentDAO studentDAO;
    private final StudentGradeDAO studentGradeDAO;
    private final StudentGradeConverter studentGradeConverter = new StudentGradeConverter();

    @Autowired
    public StudentGradeServiceImpl(StudentDAO studentDAO, StudentGradeDAO studentGradeDAO) {
        this.studentDAO = studentDAO;
        this.studentGradeDAO = studentGradeDAO;
    }

    @Override
    public StudentGradeDTO saveGrade(StudentGradeDTO studentGradeDTO) {
        validateStudentGrade(studentGradeDTO);

        final Optional<StudentDO> optionalStudentDO = studentDAO.findById(studentGradeDTO.getStudentId());
        if (optionalStudentDO.isEmpty()) {
            throw new IllegalArgumentException("Student does not exist.");
        }

        StudentGradeDO studentGradeDO = studentGradeConverter.dtoToDo(studentGradeDTO);
        studentGradeDO.setStudentId(optionalStudentDO.get());
        studentGradeDO = studentGradeDAO.save(studentGradeDO);

        return studentGradeConverter.doToDto(studentGradeDO);
    }

    private void validateStudentGrade(StudentGradeDTO studentGradeDTO) {
        if (isNull(studentGradeDTO) || isBlank(studentGradeDTO.getGradeDate()) || isNull(studentGradeDTO.getStudentId()) || isNull(studentGradeDTO.getGrade()) || studentGradeDTO.getGrade() <= 0) {
            throw new IllegalArgumentException("Student grade configuration is invalid.");
        }
    }

    @Override
    public List<StudentGradeDTO> getGradesByStudentId(Long studentId) {
        checkId(studentId);

        Optional<StudentDO> optionalUserDO = studentDAO.findById(studentId);
        if (optionalUserDO.isEmpty()) {
            return emptyList();
        }

        return studentGradeConverter.doToDto(studentGradeDAO.findAllByStudentId(optionalUserDO.get()));
    }

    @Override
    public StudentGradeDTO getById(Long id) {
        checkId(id);

        final Optional<StudentGradeDO> optionalStudentGradeDO = studentGradeDAO.findById(id);
        return optionalStudentGradeDO.map(studentGradeConverter::doToDto).orElse(null);
    }
}
