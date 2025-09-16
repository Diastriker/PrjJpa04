package com.green.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.Comments;
import com.green.dto.CommentsDTO;
import com.green.service.CommentsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentsApiController {
	
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping(value="/api/articles/{articleId}/comments")
	public ResponseEntity<CommentsDTO> create(
			@PathVariable("articleId") Long articleId, // 게시글 번호
			@RequestBody CommentsDTO commentsDTO
			) {
		log.info("dto: {}",commentsDTO);
		return null;
	}
}
