package com.ddimi.SpringTutorialAPIs.topics;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private int id;
    private String name;
    private String description;

    private static int idCounter = 5;

    public Topic() {
    }

    public Topic(String name, String description) {
        super();
        this.id = idCounter++;
        this.name = name;
        this.description = description;
    }

    public Topic(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
