package com.student.student.infrastructure.adapter.output;

import com.student.student.application.port.output.SchoolServicePort;
import com.student.student.interfaces.dto.School;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SchoolServiceAdapter implements SchoolServicePort {

    private final RestTemplate restTemplate;

    public SchoolServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public School getSchoolById(Integer schoolId) {
        return restTemplate.getForObject("http://SCHOOL-SERVICE/school/" + schoolId, School.class);
    }

    @Override
    public List<School> getAllSchools() {
        ResponseEntity<List<School>> response = restTemplate.exchange(
                "http://SCHOOL-SERVICE/schools",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<School>>() {}
        );
        return response.getBody();
    }
}
