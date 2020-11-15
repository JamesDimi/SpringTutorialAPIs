package com.ddimi.SpringTutorialAPIs.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
        this.initializeDB();
    }

    private void initializeDB() {
        topicRepository.save(new Topic(1, "java", "java tutorial"));
        topicRepository.save(new Topic(2, "c", "c tutorial"));
        topicRepository.save(new Topic(3, "python", "python tutorial"));
        topicRepository.save(new Topic(4, "c++", "c++ tutorial"));
    }

    public List<Topic> findAllTopics()  {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public List<Topic> findTopicByName(String name) {
        return new ArrayList<>(topicRepository.findByName(name));
    }

    public void addNewTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic findTopicById(int id) {
        return topicRepository.findById(id).get();
    }

    public void updateTopic(int id, Topic topic) {
        topicRepository.save(new Topic(id, topic.getName(), topic.getDescription()));
    }

    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }
}
