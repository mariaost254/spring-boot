package com.org.demo.services;

import com.org.demo.model.Student;
import com.org.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student)  {
        Optional <Student> student1 = studentRepo.findStudentByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepo.existsById(id);
        if(!exist){
            throw new IllegalStateException("student with this id doesnt exist");
        }
        studentRepo.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepo.findById(id).orElseThrow(()->
        new IllegalStateException("Student doesnt exists"));

        if (name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional <Student> student1 = studentRepo.findStudentByEmail(student.getEmail());
            if(student1.isPresent()){
                throw new IllegalStateException("email already exists");
            }
            student.setName(name);
        }


    }
}
