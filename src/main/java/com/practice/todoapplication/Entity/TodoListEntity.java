package com.practice.todoapplication.Entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "todo_list_application")
public class TodoListEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id")
    private  int id;

    @Column(name="title")
    private String title;

    @Column(name="descriptions")
    private String descriptions;

    @Column(name="completed")
    private boolean completed;



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.descriptions = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return descriptions;
    }

    public boolean isCompleted() {
        return completed;
    }



    @Override
    public String toString() {
        return "TodoListEntity{" +
                "id='" + id + '\'' +
                ", Title='" + title + '\'' +
                ", description='" + descriptions + '\'' +
                ", completed=" + completed +
                '}';
    }

    public TodoListEntity(String title, String descriptions, boolean completed, int id) {
        this.title = title;
        this.descriptions = descriptions;
        this.completed = completed;
        this.id = id;
    }

    public TodoListEntity(){

    }
}


