package com.example.springboot.web.springBootDemo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.web.springBootDemo.model.TaskToDo;

public interface TaskToDoRepository extends JpaRepository<TaskToDo, Integer>{
	List<TaskToDo> findByUser(String user);
}
