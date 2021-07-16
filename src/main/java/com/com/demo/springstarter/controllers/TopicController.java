package com.com.demo.springstarter.controllers;

import com.com.demo.springstarter.model.Topic;
import com.com.demo.springstarter.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics") // GET request by default
    public List <Topic> getAllTopics() { //converts to JSON
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public ResponseEntity<?> getTopic(@PathVariable String id) throws Exception {
        Optional<Topic> topic = topicService.getTopic(id);
        if (topic == null) {
            throw new Exception("Element not found");
        }
        return new ResponseEntity<>(topic, HttpStatus.OK);

    }

    @PostMapping(value ="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping(value ="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping(value ="/topics/{id}")
    public void removeTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
