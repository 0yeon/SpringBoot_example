package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDTO;
import com.example.demo.persistence.TodoEntity;
import com.example.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

// 3����

@RestController
@Slf4j
@RequestMapping("todo")

public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/list")
	public List<TodoDTO> list() {
		System.out.println("GET - /todo/list");
		
		List<TodoDTO> list = new ArrayList<TodoDTO>();
		List<TodoEntity> listAll = todoService.findAll();
		
		for(TodoEntity entity : listAll) {
			list.add(new TodoDTO(entity));
		}
		return list;
	}
	
	@GetMapping("/insert")
	public ResponseEntity<TodoDTO> insert(TodoDTO dto) {
		System.out.println("GET - INSERT");
		todoService.insert(dto);
		return ResponseEntity.<TodoDTO>ok().body(dto);
	}
}
