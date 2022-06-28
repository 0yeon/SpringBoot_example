package com.example.demo.dto;

import com.example.demo.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
	private String name;
	private String email;
	private String phone;
	
	public TodoDTO(final TodoEntity entity) {
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
	}
	
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder().name(dto.getName()).email(dto.getEmail()).phone(dto.getPhone()).build();
	}
}
