package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// ������ ��� ü�� ������� �����͸� �־��� �� �ִ� ��� ����
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
// 
@RequiredArgsConstructor

public class DemoModel {
	@NonNull
	private String id;
	private String pw;

}