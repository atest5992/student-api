package com.examples.studentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDTO {

    private Long id;
    private Long studentId;
    private Double grade;
    private Date gradeDate;
    private String description;
}
