package com.school.school.infrastructure.persistence.repository;

import com.school.school.infrastructure.persistence.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer> {
}
