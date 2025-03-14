package com.student.student.shared.utils.service;

import com.student.student.interfaces.dto.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class UtilService {
    public Integer getRandomSchoolId(List<School> schools) {
        if (schools == null || schools.isEmpty()) {
            Random random = new Random();
            assert schools != null;
            int randomIndex = random.nextInt(schools.size());
            return schools.get(randomIndex).getId();
        } else {
            throw new NoSuchElementException("No schools found");
        }
    }
}
