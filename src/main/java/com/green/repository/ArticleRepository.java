package com.green.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.green.dto.ArticleDTO;
import com.green.entity.Article;
import com.green.entity.Comments;

@Repository
public interface ArticleRepository
                             // <엔티티 타입, PK타입>
       extends   CrudRepository<Article, Long>{
	
	@Override
	List<Article> findAll();
	// Iterable<> findAll()  return -> List<Article> findAll()
	// 상속관계를 이용하여 List를 Iterable 로 UpCasting 하여 Casting
	
	@Transactional
	void deleteByTitle(String string);
}
