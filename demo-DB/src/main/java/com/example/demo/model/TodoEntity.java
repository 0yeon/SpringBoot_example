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

//������̼� 6��
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Todo") // �����ͺ��̽��� ����� ���̺�
public class TodoEntity {
	@Id
	@GeneratedValue(generator = "system-uuid") // ID�� �ڵ����� ����
	@GenericGenerator(name = "system-uuid", strategy = "uuid") // �� �Ѱ��༭ ����Ѵٴ°Ͱ���
	private String id; // ������̼� Id�� ���⿡ ��µ�
	private String userId;
	private String title;
	private boolean done;
}