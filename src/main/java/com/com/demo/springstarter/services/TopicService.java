package com.com.demo.springstarter.services;

import com.com.demo.springstarter.model.Topic;
import com.com.demo.springstarter.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;

//     private List<Student> topics = new ArrayList<>(Arrays.asList(
//             new Student("1","blop","blop description")
//        ));

     public List <Topic> getAllTopics(){
         List <Topic> topics = new ArrayList<>();
          topicRepo.findAll().forEach(topics::add);
          return topics;
     }

     public Optional<Topic> getTopic(String id){
        return topicRepo.findById(id);
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
     }

     public void addTopic(Topic topic){
         topicRepo.save(topic);
        // topics.add(topic);
     }

    public void updateTopic(Topic topic, String id){
//       for(int i=0; i<topics.size();i++){
//           Student t= topics.get(i);
//           if (t.getId().equals(id)){
//               topics.set(i,topic);
//               return;
//           }
//       }
        topicRepo.save(topic); //if id exists the repo will update it
    }

    public void deleteTopic(String id){
        topicRepo.deleteById(id);
         //topics.removeIf(t -> t.getId().equals(id));
    }

}
