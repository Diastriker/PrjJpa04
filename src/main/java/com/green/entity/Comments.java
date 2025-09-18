package com.green.entity;

import com.green.dto.CommentsDTO;

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
	@Column(length=255)
	private String body;

	@Column
	private String nickname;
	
	// 외래키 설정 - 지금은 PK 가 하나라 자동으로 Article에 있는 id를 참조함
	// 얘가 article객체 받을때 자동으로 PK값만 걸러서 뽑아줌
	@ManyToOne                     // 외레키 다대일 관계
	@JoinColumn(name="article_id") // 외레키 칼럼
	private Article article;       // 연결될 entity 객체의 이름
	
	
	
	public static Comments createComment(CommentsDTO dto,Article article) {
		Comments comments = new Comments(
				null, //dto.getId()
				dto.getBody(),
				dto.getNickname(),
				article
				);
		return comments;
	}

    // target <- dto
	public void patch(CommentsDTO dto) {
		if( this.id != dto.getId() ) {
			throw new IllegalArgumentException("댓글 수정 실패! 잘못된 아이디가 입력 되었습니다");
		}
		if( dto.getNickname() != null ) {
			this.nickname = dto.getNickname();
		}
		if( dto.getBody() != null ) {
			this.body = dto.getBody();
		}
		
	}

}


