package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService

{
    @Autowired
    private ToDoRepository todorepos;

    @Transactional
    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }

        return todorepos.save(currentTodo);
    }

    @Transactional
    @Override
    public Todo save(Todo todo)
    {

        return todorepos.save(todo);
    }

    @Override
    public List<Todo> findAll()
    {
        List<Todo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
