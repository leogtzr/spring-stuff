package com.cache.redis.boundaries;

import com.cache.redis.domain.Student;
import com.cache.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Students {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/view")
    @ResponseStatus(value = HttpStatus.OK)
    public void print() {
        studentRepository.findAll().forEach(s -> {
            System.out.println(s.toString());
        });
    }

    @GetMapping("/savesample")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveSample() {
        final Student student = new Student();
        student.setId("45");
        student.setGender(Student.Gender.MALE);
        student.setGrade(1);
        student.setName("Diana");

        studentRepository.save(student);
    }

    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK)
    public void get() {
        final Student retrievedStudent = studentRepository.findById("45").get();
        System.out.println(retrievedStudent);
    }

}
