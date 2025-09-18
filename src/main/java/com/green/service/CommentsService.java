package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.CommentsDTO;
import com.green.entity.Article;
import com.green.entity.Comments;
import com.green.repository.ArticleRepository;
import com.green.repository.CommentsRepository;

@Service
public class CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	// 댓글 목록 조회
	public List<Comments> getComments(Long id) {
		// ArticleId 로 조회
		List<Comments> comments = commentsRepository.findByArticleId(id);
	
	// Nickname 으로 조회 - xml으로 조회한거
//	List<Comments> comments = commentsRepository.findByNickname("Kim"); 
		return comments;
	}
	
	// 내거 코딩 댓글 추가
	public CommentsDTO createBody(Long articleId, CommentsDTO dto) {
		Article article = articleRepository.findById(articleId)
										   .orElseThrow( () -> new IllegalArgumentException
													("댓글 생성 실패 대상 게시물이 없습니다") );
		// Comments 클라스에는 생성자가 CommentsDTO, Article 이런 형식이 아니기 때문에
		  // 아래 하니씩 get으로 해야함
		    // 쌤거에 CommentsDTO 클라스에는 
		Comments comments = new Comments(null, dto.getBody(),dto.getNickname(), article);
		Comments create = commentsRepository.save(comments);
		CommentsDTO ccc = CommentsDTO.createCommentDTO(create);
		System.out.println(ccc);
		return ccc;
	}
	
	// 쌤거 코딩 댓글 추가
	public CommentsDTO create(CommentsDTO dto) {
		
		// 1. 게시글 조회 및 조회실패 예외발생
		// 게시글에 존재 하지 않는 articleId 가 넘어오면 throw(예외를 던진다)
		Article article = articleRepository.findById(dto.getArticleId())
						  .orElseThrow( () -> new IllegalArgumentException
								  ("댓글 생성 실패 대상 게시물이 없습니다") ); // 조회, 예외처리
		// 2. 댓글 엔티티 생성 -> 저장할 데이터를 만든다
		Comments comments = Comments.createComment(dto, article);
		// 3. 댓글 엔티티르 db에 저장
		Comments created = commentsRepository.save(comments);
		
		CommentsDTO newDTO = CommentsDTO.createCommentDTO(created);
		return newDTO;
	}
									
	// 댓글 수정 // id, nickname, body, articleId
	public CommentsDTO update(CommentsDTO commentsDTO) {

		Article article = articleRepository.findById(commentsDTO.getArticleId()).orElseThrow( () -> new IllegalArgumentException("수정 대상이 없습니다"));
		Comments comments = new Comments(commentsDTO.getId(), commentsDTO.getBody(), commentsDTO.getNickname(), article);
		comments = commentsRepository.save(comments);
		CommentsDTO dto = CommentsDTO.createCommentDTO(comments);
		return dto;
	}
	
	// 쌤거 수정
	public CommentsDTO patch(CommentsDTO dto) {
		
		Comments target = commentsRepository.findById(dto.getId())
				.orElseThrow( () -> new IllegalArgumentException("수정 대상이 없습니다"));;
		
	    // 2. target 의 내용중 수정할 내용을 변경
		//target : 수정될 댓글
		// dto : 수정할 입력받은 데이터
		target.patch(dto);
		// 3. 수정
		Comments updated = commentsRepository.save(target);
		CommentsDTO commentsDTO = CommentsDTO.createCommentDTO(updated);
		return commentsDTO;
	}
	
	// 댓글 삭제
	public CommentsDTO delete(Long id) {
		Comments comments = commentsRepository.findById(id).orElse(null);
		if(comments != null) {
			commentsRepository.deleteById(id);
			CommentsDTO commentsDTO = CommentsDTO.createCommentDTO(comments);
			return commentsDTO;
		}
		return null;
	}
	
} // Service End


















