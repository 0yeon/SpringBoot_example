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

	// ���� ������ ���� �� ��� ������ �Ȱ��� �Ǵ� ��찡 �ְ�
	// �������� ���ƾ� �� �κ��� ���⿡ �ִ´�.
	// ������ �����ġ
	// ������, �ܹ������� �ǰ� �ؼ� entity ���� ���� ���ϰ� �����.
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	/*
�� Dto �뵵�� ���񽺿��� ȣ���Ϸ��� ���� �Ű� �ܺο��� ������ �޾ư����� ���� ���� ���� �׷����ϴ�.
�׷��ϱ� ��� �����ڸ� �׳� ��������. ������. ���� ����. �׸��� ���������� ���� �� ���⿡�� 
entity�� ������? entity�� ��� ������ �Ȱ��ݾ�. �׷���? �׷��� �츮�� 
MyBatis�� �� ���� Dto�� �߾��µ� entity �� ��������ݾ�. �� �׷��ĸ� MyBatis�� 
�츮�� ���� sql���� �̿��ؼ� ũ������Ʈ �������ϱ� entity �ʿ�����µ� 
����� ������? �� entity��� ���� ���������� JK�� �ڵ����� ũ������Ʈ ������. 
�׷��� �ʿ��� �ſ���. ������ ��������� ����� �ٸ� �ſ���. entity�� entity �ᵵ �Ǵµ� 
entity�� �����ͺ��̽��� CRUD�� ���ؼ� �ʿ��� �Ű� TodoDTO�� �����͸� 
�۽ý��Ͻ����� �ű� ������ �ʿ��� ���̴�. �׷� �̾߱��Դϴ�.
�׷��� �����е� ���ϰ� �̷��� �ϰ� ���� �μ��� �� �ϸ� �̷� ������ ���� ���޵� �ſ���.
	 */
	
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.done(dto.isDone())
				.build();
	}
}