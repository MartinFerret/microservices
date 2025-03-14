package com.student.student.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private Integer schoolId;
}
