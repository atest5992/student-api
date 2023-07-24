package com.examples.studentapi.dao.repository;

import com.examples.studentapi.dao.entity.StudentGradeDO;
import com.examples.studentapi.dao.entity.StudentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGradeDAO extends JpaRepository<StudentGradeDO, Long> {
    List<StudentGradeDO> findAllByStudentId(StudentDO studentDO);
}
