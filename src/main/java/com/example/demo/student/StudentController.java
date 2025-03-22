package com.example.demo.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }



//    private Student toStudent(StudentResponseDto studentResponseDto){
//       var student = new Student();
//
//    }

    @GetMapping("/students")
    public List<StudentResponseDto> finaAllStudents(){
       return studentService.finaAllStudents();
    }

    @GetMapping("students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id){
        return studentService.findStudentById(id);
    }

    @GetMapping("students/search/{student-fname}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-fname") String fname){
       return studentService.findStudentsByName(fname);
    }

    @DeleteMapping("students/delete/{student-id}")
    public void deleteStudentRecord(@PathVariable("student-id") Integer id){
       studentService.deleteStudentRecord(id);
    }


@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleArgumentNotValidException(
        MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
