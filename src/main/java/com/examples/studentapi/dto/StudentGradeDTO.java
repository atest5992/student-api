package com.examples.studentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDTO {

    private Long id;
    private Long studentId;
    private Double grade;
    private String gradeDate;
    private String description;
}
