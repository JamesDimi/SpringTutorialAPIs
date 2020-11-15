package com.ddimi.SpringTutorialAPIs.topics;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// This controller works on http://localhost:8080/
@RestController
public class TopicController {

    // DONT USE AUTOWIRED... this this way instead!
    // This is a workaround!
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    // This is the first way of getting the params for GET method
    // Way to use: http://localhost:8080/topics/java
    @GetMapping("/topics/{name}")
    public List<Topic> findTopicByName(@PathVariable String name) {
        return topicService.findTopicByName(name);
    }

    // This is the second way of getting the params for GET method.
    // The bad thing is that the original /topics method doesn't work!
    // how to call: http://localhost:8080/topics?name=c
//    @GetMapping("/topics")
//    public List<Topic> findTopicByName(@RequestParam(value = "name", defaultValue = "java") String name) {
//        return topicService.findTopicByName(name);
//    }

    // This is the first way of using the POST method
    // Adds a new topic to the DB and returns the DB entry to confirm it works
    // Way to use: http://localhost:8080/topics
    // Use postman and make a POST method while typing Content-type = json
    // and making a new json payload of the Topic
    @PostMapping("/topics")
    public Topic addNewTopic(@RequestBody Map<String, String> input) {
        Topic nTopic = new Topic(input.get("name"), input.get("description"));
        topicService.addNewTopic(nTopic);
        return topicService.findTopicById(nTopic.getId());
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Map<String, String> input, @PathVariable int id) {
        Topic nTopic = new Topic(input.get("name"), input.get("description"));
        topicService.updateTopic(id, nTopic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
    }
}
