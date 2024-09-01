package com.practice.todoapplication.dao;

import com.practice.todoapplication.Entity.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <TodoListEntity, Integer>{
}
