package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

// ResponseDTO -> DTOµÈ¿« π≠¿Ω. 
public class ResponseDTO<T> {
	private String error;
	private List<T> data;

}
