package com.student.student.domain.service;

import com.student.student.application.port.output.SchoolServicePort;
import com.student.student.domain.model.Student;
import com.student.student.infrastructure.persistence.entity.StudentEntity;
import com.student.student.infrastructure.persistence.repository.StudentRepository;
import com.student.student.interfaces.dto.School;
import com.student.student.interfaces.dto.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolServicePort schoolServicePort;

    public StudentService(StudentRepository studentRepository, SchoolServicePort schoolServicePort) {
        this.studentRepository = studentRepository;
        this.schoolServicePort = schoolServicePort;
    }

    public ResponseEntity<?> createStudent(Student student) {
        try {
            StudentEntity entity = StudentEntity.fromDomain(student);

            StudentEntity savedEntity = studentRepository.save(entity);

            Student savedStudent = savedEntity.toDomain();

            return new ResponseEntity<>(savedStudent, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStudentById(String id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);

        if (studentEntity.isPresent()) {
            Student student = studentEntity.get().toDomain();

            School school = schoolServicePort.getSchoolById(student.getSchoolId());

            StudentResponse studentResponse = new StudentResponse(
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getGender(),
                    school
            );

            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
        }
    }

    public List<StudentResponse> getStudentsWithoutSchool() {
        List<StudentEntity> studentEntities = studentRepository.findBySchoolIdIsNull();

        return studentEntities.stream()
                .map(entity -> {
                    Student student = entity.toDomain();
                    return new StudentResponse(
                            student.getId(),
                            student.getName(),
                            student.getAge(),
                            student.getGender(),
                            null
                    );
                })
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> fetchStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();

        if (!studentEntities.isEmpty()) {
            List<Student> students = studentEntities.stream()
                    .map(StudentEntity::toDomain)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Students", HttpStatus.NOT_FOUND);
        }
    }
}
