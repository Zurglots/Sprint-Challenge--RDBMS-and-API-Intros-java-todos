package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo update(Todo todo, long id);

    Todo save(Todo todo);
}
