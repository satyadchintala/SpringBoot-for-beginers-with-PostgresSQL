package com.example.springboot.web.springBootDemo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.web.springBootDemo.model.TaskToDo;

public interface UserRepository extends JpaRepository<TaskToDo, Integer>{
	
}
