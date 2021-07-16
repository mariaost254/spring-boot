package com.com.demo.springstarter.repository;

import com.com.demo.springstarter.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepo extends JpaRepository<Topic,String> {
    //repo.findByTopic(topic.getEmail())
    //@Query("SELECT s from Courses where s.email = ?1 ")
    //List<Student> findByTopic();
}
