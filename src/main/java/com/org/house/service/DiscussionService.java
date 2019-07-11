package com.org.house.service;

import com.org.house.entity.Topic;
import com.org.house.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }
}
