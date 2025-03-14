package com.student.student.application.port.output;

import com.student.student.interfaces.dto.School;

import java.util.List;

public interface SchoolServicePort {
    School getSchoolById(Integer schoolId);
    List<School> getAllSchools();
}
