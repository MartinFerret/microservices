package com.student.student.infrastructure.persistence.entity;

import com.student.student.domain.model.Student;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "students")
public class StudentEntity {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private Integer schoolId;

    public Student toDomain() {
        return new Student(this.id, this.name, this.age, this.gender, this.schoolId);
    }

    public static StudentEntity fromDomain(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.id = student.getId();
        entity.name = student.getName();
        entity.age = student.getAge();
        entity.gender = student.getGender();
        entity.schoolId = student.getSchoolId();
        return entity;
    }
}
