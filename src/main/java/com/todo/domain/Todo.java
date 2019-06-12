package com.todo.domain;

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

    public Todo() {
    }

    public Todo(String content) {
        this.content = content;
    }
}
