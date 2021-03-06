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
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

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
   
   @PostMapping("/insert")
   public ResponseEntity<TodoDTO> insert(TodoDTO dto) {
      log.info(">>>>>> ", dto.toString());
      todoService.insert(dto);
      System.out.println(">>>>>> " + dto.toString());
      return ResponseEntity.<TodoDTO>ok().body(dto);
   }
}