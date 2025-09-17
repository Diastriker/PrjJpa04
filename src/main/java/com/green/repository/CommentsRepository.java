package com.green.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Comments;

// JpaRepository : CrudRepository + PagingAndSortingRepository
@Repository
public interface CommentsRepository 
  extends   JpaRepository<Comments, Long>{
	
	@Override
	// Iterable 를 List 로 다운캐스팅 - findAll() 리턴값이 Iterable
	List<Comments> findAll();
	
	// @qUERY : FindByArticleId() 함수를 호출하면
	 // JPA 기능이 아닌 @Query 안의 sql(JPQL)을 실행한다
	// nativeQuery = true :  oracle 문법의 sql이 작동된다 
	// nativeQuery = false : JPQL 문법의 sql이 작동된다
	 
	@Query(value="SELECT * FROM COMMENTS WHERE ARTICLE_ID=:articleId",
		   nativeQuery=true)
	List<Comments> findByArticleId(Long articleId);	
	/*List<Comments> findByArticleId(Long id);*/ // 이것도 댐
	// findBY 뒤에는 PK가있는 엔티티 이름과 동일해야함
	// Id 는 @Id 기준으로 찾는다
	
	// native query cml
	// src/main/resources/META-INF/orm.xml 폴더와 파일을 생성해야한다
	// orm.xml 에 sql 을 저장해서 findByNickname함수호출
	List<Comments> findByNickname(String nickname);

	
	// 기본 findBYId()를 직접 JPQL 로 작성
	// @Query("SELECT a FROM ARTICLE a WHERE a.id=:id")
	// Optional<Article> findById(@Param("id") Long id);
}









