package com.examples.studentapi.dao.repository;

import com.examples.studentapi.dao.entity.StudentDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentDO, Long> {

}
