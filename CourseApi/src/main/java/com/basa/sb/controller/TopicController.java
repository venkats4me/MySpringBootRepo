package com.basa.sb.controller;

import com.basa.sb.model.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
      return Arrays.asList(new Topic(123,"java 8 Streams","about java 8"),
        new Topic(143,"java 11 Streams","about java 11"),
              new Topic(153,"java 21 Streams","about java 21"),
              new Topic(134,"Spring Boot3","about Spring boot3"),
              new Topic(193,"SpringBoot and MicroServices","about SpringBoot and MicroServices")

      );
    }
}
