package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoService {
   @Autowired
   TodoDAO repository;

	public List<TodoEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public void insert(TodoDTO dto) {
		TodoEntity entity = TodoEntity
				.builder()
				.title(dto.getTitle())
				.done(dto.isDone())
				.build();
		repository.save(entity);
	}
}