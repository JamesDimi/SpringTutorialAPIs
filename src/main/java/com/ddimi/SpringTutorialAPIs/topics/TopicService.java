package com.ddimi.SpringTutorialAPIs.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
        this.initializeDB();
    }

    private void initializeDB() {
        topicRepository.save(new Topic("1", "java", "java tutorial"));
        topicRepository.save(new Topic("2", "c", "c tutorial"));
        topicRepository.save(new Topic("3", "python", "python tutorial"));
    }

    public List<Topic> findAllTopics()  {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
}
