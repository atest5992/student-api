package com.examples.studentapi.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@Entity
@Table(name = "student_grade", schema = "student_db")
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", updatable = false)
    private StudentDO studentId;

    @Column(name = "grade")
    private Double grade;

    @Column(name = "grade_date")
    private Date gradeDate;

    @Column(name = "description")
    private String description;
}
