package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//어노테이션 6개
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Todo") // 데이터베이스에 저장될 테이블
public class TodoEntity {
	@Id
	@GeneratedValue(generator = "system-uuid") // ID를 자동으로 생성
	@GenericGenerator(name = "system-uuid", strategy = "uuid") // 걍 넘겨줘서 사용한다는것같음
	private String id; // 어노테이션 Id을 여기에 담는듯
	private String userId;
	private String title;
	private boolean done;
}
