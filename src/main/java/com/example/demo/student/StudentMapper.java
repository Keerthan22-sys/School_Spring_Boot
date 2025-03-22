package com.example.demo.student;

import com.example.demo.school.School;
import org.springframework.stereotype.Service;

@Service


public class StudentMapper {
    public  Student toStudent(StudentDto studentDto) {
        if(studentDto == null) {
            throw new NullPointerException("The StudentDto should not be null");
        }
        var student = new Student();
        student.setFirstName(studentDto.firstname());
        student.setLastName(studentDto.lastname());
        student.setEmail(studentDto.email());
        student.setAge(studentDto.age());

        var school = new School( );
        school.setId(studentDto.schoolId());
        student.setSchool(school);

        return student;


    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
    }

}
