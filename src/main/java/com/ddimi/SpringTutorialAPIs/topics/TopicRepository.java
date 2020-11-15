package com.ddimi.SpringTutorialAPIs.topics;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer>{
    List<Topic> findByName(String name);
}