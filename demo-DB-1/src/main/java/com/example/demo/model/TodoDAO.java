package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.TodoEntity;

@Repository
public interface TodoDAO extends JpaRepository<TodoEntity, String> {
	List<TodoEntity> findByid(String id);
	
}
