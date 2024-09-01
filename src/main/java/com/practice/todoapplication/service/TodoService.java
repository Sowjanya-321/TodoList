package com.practice.todoapplication.service;

import com.practice.todoapplication.Entity.TodoListEntity;
import com.practice.todoapplication.dao.TodoRepository;
import com.practice.todoapplication.model.TodoList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository theTodoRepository) {
        todoRepository = theTodoRepository;
    }

    public List<TodoList> findAll() {
        List<TodoListEntity> todoListEntityList = todoRepository.findAll();

        List<TodoList> todoList = new ArrayList<>();
        for (TodoListEntity todoListEntity : todoListEntityList) {
            TodoList todo = new TodoList();
            todo.setTitle(todoListEntity.getTitle());
            todo.setId(todoListEntity.getId());
            todo.setDescription(todoListEntity.getDescription());
            todo.setComplete(todoListEntity.isCompleted());
            todoList.add(todo);
        }
        return todoList;
    }

    public TodoList getById(int id) {
        TodoListEntity todoListRecord = todoRepository.findById(id).get();
        TodoList todoList = new TodoList();
        todoList.setId(todoListRecord.getId());
        todoList.setTitle(todoListRecord.getTitle());
        todoList.setDescription(todoListRecord.getDescription());
        todoList.setComplete(todoListRecord.isCompleted());
        return todoList;

    }

    public TodoList updateList(int id, TodoList todoList) {

    TodoListEntity todoListRecord = todoRepository.findById(id).get();

    if (todoList.getTitle() != null){
        todoListRecord.setTitle(todoList.getTitle());
    }

    if (todoList.isComplete() != null){
        todoListRecord.setCompleted(todoList.isComplete());
    }

    if (todoList.getDescription() != null){
        todoListRecord.setDescription(todoList.getDescription());
    }

    TodoListEntity theTodoListEntity = todoRepository.save(todoListRecord);
    TodoList todoList1 = new TodoList();
    todoList1.setTitle(theTodoListEntity.getTitle());
    todoList1.setComplete(theTodoListEntity.isCompleted());
    todoList1.setId(theTodoListEntity.getId());
    todoList1.setDescription(theTodoListEntity.getDescription());
    return todoList1;
    }


    public TodoList save(TodoList theTodoList){
        TodoListEntity todoListEntity = new TodoListEntity();
        todoListEntity.setTitle(theTodoList.getTitle());
        todoListEntity.setDescription(theTodoList.getDescription());
        todoListEntity.setCompleted(theTodoList.isComplete());

        TodoListEntity theTodoListEntity = todoRepository.save(todoListEntity);
        TodoList todoList = new TodoList();
        todoList.setId(theTodoListEntity.getId());
        todoList.setTitle(theTodoListEntity.getTitle());
        todoList.setDescription((theTodoListEntity.getDescription()));
        todoList.setComplete(theTodoListEntity.isCompleted());

        return todoList;

    }

    public  void deleteById(int theId){
        todoRepository.deleteById(theId);
    }



}
