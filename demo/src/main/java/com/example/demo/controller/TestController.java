//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dto.ResponseDTO;
//import com.example.demo.dto.TodoDTO;
//import com.example.demo.model.TodoEntity;
//
//@Controller
//// ???ڿ??? ?????? (ResponseBody ?Ƚᵵ??)
//@RestController
//@RequestMapping("test")
//public class TestController {
//	@GetMapping
//	public String getDefault() {
////		TodoEntity todo = TodoEntity.builder().id("park").userId("LEE").title("???Ա?").build();
//		
//		TodoEntity todo = new TodoEntity("a", "kim", "????", false);
//		return todo.toString();
//	}
//	
//	@GetMapping("getMapping")
//	public String getMapping() {
//		return "GET - getMapping ...";
//	}
//	
//	@GetMapping("/{id}/{userId}")
//	public String pathVariable(
//			@PathVariable(required = false) int id,
////			@PathVariable(required = false) String userId)
//			@PathVariable String userId
//	) { 
//		return "GET - pathVariable - " + id + ", " + userId;
//	}
//	
//	@PostMapping("/beanParam")
//	public String beanParam(TodoEntity todo) {
//		return todo.toString();
//	}
//	
////	// RequestBody -> JSON ???????? ??ü?? ?޾ƿ?
////	@GetMapping("/requestBody")
////	public String requestBody(@RequestBody TodoDTO tododto) {
////		return tododto.toString(); 
////	}
//
//	// RequestBody -> JSON ???????? ??ü?? ?޾ƿ?
////	@GetMapping("/requestBody")
////	public RespnoseDTO<String> requestBody() {
////	public ResponseDTO<String> requestBody() {
////		List<String> list = new ArrayList<String>();
////		list.add("Hello");
////		list.add("world");
////		ResponseDTO<List> responseDTO = new ResponseDTO<List>();
////		return responseDTO;
////	}
//	
//   @GetMapping("/responseBody")
//   public ResponseDTO<String> responseBody() {
//      List<String> list = new ArrayList<String>();
//      list.add("Hello ");
//      list.add("world");
//      ResponseDTO<String> responseDTO = new ResponseDTO<String>(null, list);
//      return responseDTO;
//   }
//
////   @GetMapping("/responseEntity")
////	public ResponseEntity<?> responseEntity() {
////		List<String> list = new ArrayList<String>();
////		list.add("Hello " );
////		list.add("world");
////		
////		ResponseDTO<String> body = ResponseDTO.<String>builder().data(list).build();
////		return ResponseEntity.badRequest().body(body);
////	}
//   
//   @GetMapping("/responseEntity")
//	public ResponseEntity<?> responseEntity() {
//		List<String> list = new ArrayList<String>();
//		list.add("Hello " );
//		list.add("world");	
//		ResponseDTO<String> body = ResponseDTO.<String>builder().data(list).build();
//		return ResponseEntity.ok().body(body);
//	}
//}


package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;

//@Controller
@RestController
@RequestMapping("test")
public class TestController {
   
   @GetMapping
   public String getDefault() {
      //TodoEntity todo = TodoEntity.builder().id("lee001").userId("LEE").title("???Ա?").build();
      TodoEntity todo = new TodoEntity("a001", "KIM", "?????ϱ?", false);
      return todo.toString();
   }
   
   @GetMapping("/getMapping")
   public String getMapping() {
      return "GET - getMapping ...";
   }
   
   @GetMapping("/{id}/{userId}")
   public String pathVariable(
         @PathVariable(required = false) int id,
         @PathVariable String userId
         ) {
      return "GET - pathVariable - "+ id +", "+userId;
   }
   
   @PostMapping("/beanParam")
   public String beanParam(TodoEntity todo) {
      return todo.toString();
   }
   
   @GetMapping("/requestBody")
   public String requestBody(@RequestBody TodoDTO todoDto) {
      return todoDto.toString();
   }
   
   @GetMapping("/responseBody")
   public ResponseDTO<String> responseBody() {
      List<String> list = new ArrayList<String>();
      list.add("Hello ");
      list.add("world");
      ResponseDTO<String> responseDTO = new ResponseDTO<String>(null, list);
      return responseDTO;
   }
   
   @GetMapping("/responseEntity")
   public ResponseEntity<?> responseEntity() {
      List<String> list = new ArrayList<String>();
      list.add("Hello ");
      list.add("world");
      ResponseDTO<String> body = ResponseDTO.<String>builder().data(list).build();
      return ResponseEntity.badRequest().body(body);
   }
}