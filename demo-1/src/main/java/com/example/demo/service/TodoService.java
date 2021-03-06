package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class TodoService {
	@Autowired
	private TodoRepository repository;
	
	public List<TodoEntity> create(final TodoEntity entity) {
		validate(entity);
		repository.save(entity);
		log.info("Entity Id : {} is saved.", entity.getId());
		
		return repository.findByid(entity.getId());
	}
	
	private void validate(TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		
		if(entity.getId() == null) {
			log.warn("Unkown user.");
			throw new RuntimeException("Unkown user.");
		}
	}
	

}
