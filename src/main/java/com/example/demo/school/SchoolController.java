package com.example.demo.school;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto schoolDto) {

        return schoolService.create(schoolDto);

    }

    @GetMapping("/schools/{schoolid}")
    public ResponseEntity<Optional<School>> getSchoolById(@PathVariable int schoolid) {
        return schoolService.getSchoolNameById(schoolid);
    }

//    private School toSchool(SchoolDto dto) {
//        return new School(dto.school());
//    }


    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolService.findAll();
    }
}

