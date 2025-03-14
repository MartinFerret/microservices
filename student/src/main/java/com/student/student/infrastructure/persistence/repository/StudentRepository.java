package com.student.student.infrastructure.persistence.repository;

import com.student.student.domain.model.Student;
import com.student.student.infrastructure.persistence.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {
    List<StudentEntity> findBySchoolIdIsNull();
}
