package com.school.school.infrastructure.persistence.mapper;

import com.school.school.domain.model.School;
import com.school.school.infrastructure.persistence.entity.SchoolEntity;
import org.modelmapper.ModelMapper;

public class SchoolMapper {

    private final ModelMapper modelMapper;

    public SchoolMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public School toDomain(SchoolEntity entity) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, School.class);
    }

    public SchoolEntity fromDomain(School school) {
        if (school == null) {
            return null;
        }
        return modelMapper.map(school, SchoolEntity.class);
    }
}
