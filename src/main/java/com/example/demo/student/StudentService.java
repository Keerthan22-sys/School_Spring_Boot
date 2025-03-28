
package com.example.demo.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
//        studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> finaAllStudents(){

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
//                .collect(Collectors.toList())

    }

    public List<StudentResponseDto> findStudentsByName(String fname){
        return studentRepository.findAllByFirstName(fname).stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public void deleteStudentRecord( Integer id){
        studentRepository.deleteById(id);
    }

}

