package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

// NO를 의미하는 듯
@Repository
public interface TodoDAO extends JpaRepository<TodoEntity, String> {
	List<TodoEntity> findByid(String id);

}
