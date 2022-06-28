package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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

	public String testService() {
		// 생성
		TodoEntity entity = TodoEntity.builder().title("인생무상").build();

		// 저장
		repository.save(entity);

		// 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
	}
	
	// 모두 출력
	public List<TodoEntity> findAll() {
//		TodoService에 findAll하면 결과가 Controller로 넘어감
		return repository.findAll();
	}

	public List<TodoEntity> create(final TodoEntity entity) {
		validate(entity);
		repository.save(entity);

		log.info("Entity Id : {} is saved.", entity.getId());
		return repository.findByUserId(entity.getUserId());

	}

	private void validate(TodoEntity entity) {
		// TODO Auto-generated method stub

		if (entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}

		if (entity.getUserId() == null) {
			log.warn("Unkown user.");
			throw new RuntimeException("Unkown user.");
		}
	}
	
	public List<TodoEntity> update(final TodoEntity entity) {
		validate(entity);
		
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		original.ifPresent(todo -> {
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			repository.save(todo);
		});
			
		return retrieve(entity.getUserId());
	}
	
	public List<TodoEntity> retrieve(final String userId) {
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> delete(final TodoEntity entity) {
		validate(entity);
		
		try {
			repository.delete(entity);
		} catch(Exception e) {
			log.error("error deleting entity", entity.getId(), e);
			throw new RuntimeException("error deleting entity " + entity.getId());
		}
		return retrieve(entity.getUserId());
	}
}
