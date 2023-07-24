package com.examples.studentapi.service;

import com.examples.studentapi.common.converter.StudentGradeConverter;
import com.examples.studentapi.dao.entity.StudentDO;
import com.examples.studentapi.dao.repository.StudentGradeDAO;
import com.examples.studentapi.dao.repository.StudentDAO;
import com.examples.studentapi.dto.StudentGradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

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
    public List<StudentGradeDTO> getGradesByStudentId(Long studentId) {
        checkId(studentId);

        Optional<StudentDO> optionalUserDO = studentDAO.findById(studentId);
        if (optionalUserDO.isEmpty()) {
            return emptyList();
        }
        return studentGradeConverter.doToDto(studentGradeDAO.findAllByStudentId(optionalUserDO.get()));

    }

    @Override
    public List<StudentGradeDTO> findAllStudentGrades() {
        return studentGradeConverter.doToDto(studentGradeDAO.findAll());
    }

    @Override
    public StudentGradeDTO addNote(Long gradeId, String note) {
        return null;
    }
}
