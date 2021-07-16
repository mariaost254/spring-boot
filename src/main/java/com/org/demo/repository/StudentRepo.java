package com.org.demo.repository;

import com.org.demo.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

// select * from student where email =?
    @Query("SELECT s FROM Student s where s.email =?1")
    Optional<Student> findStudentByEmail(String email);
}
