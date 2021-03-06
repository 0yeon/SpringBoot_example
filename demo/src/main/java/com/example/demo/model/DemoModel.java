package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// 생성자 대신 체인 방식으로 데이터를 넣어줄 수 있는 기능 제공
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
