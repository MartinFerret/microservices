package com.school.school.application.port.output;

import com.school.school.domain.model.School;

import java.util.List;

public interface SchoolServicePort {
    School addSchool(School school);
    List<School> fetchSchools();
    School fetchSchoolById(int id);
}
