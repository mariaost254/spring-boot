package com.org.demo.repository;

import com.org.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    List<Student> commandLineRunner(StudentRepo repo){
        List <Student> studentList = new ArrayList<>(Arrays.asList(
            new Student("d","d", LocalDate.of(2000, Month.JULY,2)),
            new Student("dd","dd", LocalDate.of(1999, Month.JULY,2))));
            repo.saveAll(studentList);
        return repo.saveAll(studentList);
    }
}
