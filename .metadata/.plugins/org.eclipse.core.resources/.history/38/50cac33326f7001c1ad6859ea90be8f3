package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoDAO;
import com.example.demo.persistence.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoService {
	@Autowired
	TodoDAO repository;
	
	// ¸ñ·Ï
	public List<TodoEntity> findAll() {
		return repository.findAll();
	}
	
	// »ðÀÔ
	public void insert(TodoDTO dto) {
		TodoEntity entity = TodoEntity
				.builder()
				.title(dto.getTitle())
				.done(dto.isDone())
				.build();
		repository.save(entity);
	}
	
	public void update(TodoDTO dto) {
		final Optional<TodoEntity> original = repository.findById(dto.getId());
		original.ifPresent(todo -> {
			todo.setTitle(dto.getTitle());
			todo.setDone(dto.isDone());			
			repository.save(todo);
		});
	}

	
}