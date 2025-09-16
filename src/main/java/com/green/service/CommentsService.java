package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.Article;
import com.green.dto.Comments;
import com.green.dto.CommentsDTO;
import com.green.repository.ArticleRepository;
import com.green.repository.CommentsRepository;

@Service
public class CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;
	
	public List<Comments> getComments(Long id) {
		// ArticleId 로 조회
		List<Comments> comments = commentsRepository.findByArticleId(id);
	
	// Nickname 으로 조회 - xml으로 조회한거
//	List<Comments> comments = commentsRepository.findByNickname("Kim"); 
		return comments;
	}
	
}
