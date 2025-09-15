package com.green.dto;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
/*
 * @SequenceGenerator(
 * 
 * )
 */
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String body;
	
	@Column
	private String nickname;
	
	@Column
	@ManyToOne
	private Long article_id;
}
