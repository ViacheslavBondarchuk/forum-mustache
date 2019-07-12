package com.org.house.service;

import com.org.house.DTO.TopicDTO;
import com.org.house.entity.Topic;
import com.org.house.repository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    TopicRepository topicRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public void saveDiscussion(TopicDTO topicDTO) {
        topicDTO.setDate(new Date());
        topicRepository.save(modelMapper.map(topicDTO, Topic.class));
    }
}
