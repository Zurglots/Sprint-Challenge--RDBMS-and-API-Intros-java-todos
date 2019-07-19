package com.lambdaschool.todos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todo")
public class Todo extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

//    private Date datestarted;
//    private Boolean completed;

    @ManyToOne
    @JsonIgnoreProperties("todo")
    @JoinColumn(name = "userid")
    private User user;

    public Todo() {
    }
// new Date(), from seed data
    //Date datestarted,
//    Boolean completed,
    public Todo(String description, User user)
    {
        this.description = description;
//        this.datestarted = datestarted;
//        this.completed = completed;
        this.user = user;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Date getDatestarted() {
//        return datestarted;
//    }
//
//    public void setDatestarted(Date datestarted) {
//        this.datestarted = datestarted;
//    }
//
//    public Boolean getCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(Boolean completed) {
//        this.completed = completed;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
