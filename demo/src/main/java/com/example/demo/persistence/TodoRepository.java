package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

// TableName, Primary Type
// �� �������丮 ��ü�� DB
// CRUD �������丮 ��ӹ���
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
   //@Query("select * from todo")
	
	// create abstract method
   List<TodoEntity> findByUserId(String userId);
   
}
