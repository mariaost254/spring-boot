package com.org.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name ="Student")
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "dob")
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student(String dd, String dd1, LocalDate of) {
        this.name = dd;
        this.email = dd1;
        this.dob = of;
    }

    //for joining from another table
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "deptid", referencedColumnName = "deptid")
//    private Department deptartment;

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

}
