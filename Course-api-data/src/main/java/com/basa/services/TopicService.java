package com.basa.services;

import com.basa.model.Topic;
import com.basa.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    TopicRepo repo;
    public void addTopicToDb(Topic topic) {
        repo.save(topic);
    }

    public List<Topic> getAllTopicToDb() {
        return repo.findAll();
    }

    public Optional<Topic> gettopicToDb(int id) {
        return repo.findById(id);
    }
}
