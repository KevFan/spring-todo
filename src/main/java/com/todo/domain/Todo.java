package com.todo.domain;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */

public class Todo {
    private Long id;
    private String content;

    public Todo(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
