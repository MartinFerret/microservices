package com.school.school.domain.service;

import com.school.school.application.port.output.SchoolServicePort;
import com.school.school.domain.model.School;
import com.school.school.infrastructure.persistence.entity.SchoolEntity;
import com.school.school.infrastructure.persistence.mapper.SchoolMapper;
import com.school.school.infrastructure.persistence.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService implements SchoolServicePort {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    @Override
    public School addSchool(School school) {
        SchoolEntity entity = schoolMapper.fromDomain(school);
        SchoolEntity savedEntity = schoolRepository.save(entity);
        return schoolMapper.toDomain(savedEntity);
    }

    @Override
    public List<School> fetchSchools() {
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public School fetchSchoolById(int id) {
        return schoolRepository.findById(id)
                .map(schoolMapper::toDomain)
                .orElse(null);
    }
}
