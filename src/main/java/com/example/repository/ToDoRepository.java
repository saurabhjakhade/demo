package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.ToDo;


public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
