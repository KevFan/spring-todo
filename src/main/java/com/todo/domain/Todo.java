package com.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToOne
    @JsonIgnore
    private User user;

    public Todo() {
    }

    public Todo(String content, User user) {
        this.content = content;
        this.user = user;
    }
}
