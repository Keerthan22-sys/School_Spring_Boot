package com.example.demo.student;

import com.example.demo.school.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    @Id
    @GeneratedValue
            (strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "c_fname",length = 69)
    private String firstName;
    @Column(name = "c_lname",length = 69)
    private String lastName;
    @Column(name = "c_email", unique = true)
    private String email;
    @Column(name = "c_age", length = 4)
    private int age;
//    @Column(updatable = false)
//    private String password;
    @ManyToOne
    @JoinColumn(
            name = "school_id"

    )
    @JsonBackReference
    private School school;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private com.example.demo.studentprofile.StudentProfile studentProfile;

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.demo.studentprofile.StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(com.example.demo.studentprofile.StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Student() {
    }


    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }
}

