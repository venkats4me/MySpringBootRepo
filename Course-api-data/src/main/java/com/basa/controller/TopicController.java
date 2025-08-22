package com.basa.controller;

import com.basa.model.Topic;
import com.basa.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @PostMapping("/add")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){
         topicService.addTopicToDb(topic);
        return ResponseEntity.ok(topic);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Topic>> getAllTopics(){
        return ResponseEntity.ok(topicService.getAllTopicToDb());
    }
    @GetMapping("/topic/{id}")
    public ResponseEntity<Optional<Topic>> getTopicById(@PathVariable("id") int id){
        Optional<Topic> top=topicService.gettopicToDb(id);
        return ResponseEntity.ok(top);
    }
}
