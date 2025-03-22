package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

//  public SchoolDto toSchoolDto() {
//      return new School(toSchoolDto().name());
//  }

    public School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.school());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getSchool());
    }


}
