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
	private String id;
	private String title;
	private boolean done;

	// 서비스 쪽으로 보낼 때 모든 정보가 안가야 되는 경우가 있고
	// 공개되지 말아야 할 부분을 여기에 넣는다.
	// 일종의 잠금장치
	// 참조값, 단방향으로 되게 해서 entity 값을 변경 못하게 만든다.
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	/*
이 Dto 용도는 서비스에서 호출하려고 쓰는 거고 외부에서 데이터 받아가지고 넣을 때도 쓰고 그렇습니다.
그러니까 얘는 말하자면 그냥 포장지야. 포장지. 포장 용지. 그리고 직접적으로 이제 그 여기에서 
entity는 뭐예요? entity가 사실 구조는 똑같잖아. 그렇죠? 그런데 우리가 
MyBatis를 할 때는 Dto만 했었는데 entity 안 만들었었잖아. 왜 그렇냐면 MyBatis는 
우리가 직접 sql문을 이용해서 크리에이트 시켰으니까 entity 필요없었는데 
여기는 뭐예요? 저 entity라는 것을 만들어놓으면 JK가 자동으로 크리에이트 시켜줘. 
그래서 필요한 거예요. 구조가 비슷하지만 모양이 다른 거예요. entity는 entity 써도 되는데 
entity는 데이터베이스에 CRUD를 위해서 필요한 거고 TodoDTO는 데이터를 
퍼시스턴스까지 옮길 때까지 필요한 것이다. 그런 이야기입니다.
그래서 여러분들 저하고 이렇게 하고 각자 두세번 더 하면 이런 구조는 거의 숙달될 거예요.
	 */
	
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.done(dto.isDone())
				.build();
	}
}
