package com.org.house.service;

import com.org.house.DTO.TopicDTO;
import com.org.house.entity.Comment;
import com.org.house.entity.Topic;
import com.org.house.repository.CommentRepository;
import com.org.house.repository.TopicRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CommentRepository commentRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public void saveDiscussion(TopicDTO topicDTO) {
        topicDTO.setDate(new Date());
        topicRepository.save(modelMapper.map(topicDTO, Topic.class));
    }

    public Topic getTopic(int id) throws NotFoundException {
        return topicRepository.findById(id).orElseThrow(() -> new NotFoundException("Topic not found"));
    }

    public void addComment(String text, int id) throws NotFoundException {
        Comment comment = new Comment();
        comment.setText(text);
        comment.setTopic(topicRepository.findById(id).orElseThrow(() -> new NotFoundException("Topic not found")));

        commentRepository.save(comment);
    }

    public List<Comment> getAllComments(int id){
       return commentRepository.findByTopic(id);
    }
}
