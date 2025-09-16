package com.green.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@SequenceGenerator(
	name = "COMMENTS_SEQ_GENERATOR",
	sequenceName= "COMMENTS_SEQ", // create sequence COMMEN-SEQ
	initialValue = 1, // 초기값
	allocationSize = 1 // 증가치
)
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "COMMENTS_SEQ_GENERATOR") // 번호 자동 증가
	private Long id;
	
//	@Column(name="nick_name", nullable=true, length=255)
	// Oracle 11g VARCHAR2 최대 4000 -> CLOB
	// Oracle 12c VARCHAR2 최대 32000 -> 별도 설정 필요
	@Column
	private String body;

	@Column
	private String nickname;
	
	// 외래키 설정
	@ManyToOne                     // 외레키 다대일 관계
	@JoinColumn(name="article_id") // 외레키 칼럼
	private Article article;       // 연결될 entity 객체의 이름
}
