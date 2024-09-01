package com.practice.todoapplication.controller;


import com.practice.todoapplication.model.TodoList;
import com.practice.todoapplication.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService theTodoService){
        todoService=theTodoService;
    }

    @GetMapping("/todoList")
    public List<TodoList> findAll(){
        List<TodoList> todoListEntityList = todoService.findAll();
        return todoListEntityList;
    }

    @GetMapping("/getTodoList/{id}")
    public TodoList getById(@PathVariable int id){
        TodoList todoList = todoService.getById(id);
        return todoList;
    }

    @PostMapping("/addlist")
    public  TodoList save(@RequestBody TodoList theTodoList){
        TodoList dbTodoList = todoService.save(theTodoList);
        return dbTodoList;
    }

    @DeleteMapping("/deleteById/{theId}")
    public void deleteById(@PathVariable int theId){
       todoService.deleteById(theId);
    }
    @PutMapping("/updateList/{id}")
    public TodoList updateList(@PathVariable int id, @RequestBody TodoList todoList){
        TodoList theTodoList = todoService.updateList(id,todoList);
        return theTodoList;
    }

}
