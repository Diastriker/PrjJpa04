package com.green.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.CommentsDTO;
import com.green.entity.Comments;
import com.green.service.CommentsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentsApiController {
	
	@Autowired
	private CommentsService commentsService;
	
	
	// 내거
	@PostMapping(value="/api/articles/{articleId}/comments")
	public ResponseEntity<CommentsDTO> create(
			@PathVariable("articleId") Long articleId, // 게시글 번호
			@RequestBody CommentsDTO dto
			) {
		
		CommentsDTO created = commentsService.createBody(articleId, dto); 
		
		ResponseEntity<CommentsDTO> result = (created != null)
				? ResponseEntity.status(HttpStatus.OK).body(created)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		log.info("dto: {}",dto);
		return result;
	}
	/*
	// 쌤거
	@PostMapping(value="/api/articles/{articleId}/comments")
	public ResponseEntity<CommentsDTO> create(
			@PathVariable("articleId") Long articleId, // 게시글 번호
			@RequestBody CommentsDTO commentsDTO
			) {
		
		CommentsDTO created = commentsService.create(commentsDTO); 

		return ResponseEntity.status(HttpStatus.OK).body(created);
	}
	*/
	@PatchMapping(value="/api/comments/{id}")
	public ResponseEntity<CommentsDTO> update(
			@PathVariable("id") Long id,
			@RequestBody CommentsDTO commentsDTO
			) {
		
		CommentsDTO updated = commentsService.update(commentsDTO);
		ResponseEntity<CommentsDTO> result = (updated != null)
				? ResponseEntity.status(HttpStatus.OK).body(updated)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return result;
	}
}





