

	// 모달창을 찾는다
	const updateModalEl     = document.querySelector('#updateModal') 

	// 이벤트 연결 :
	// show.bs.modal   - modal창이 화면에 그려지기 전에
	// shown.bs.modal  - modal창이 열리고 화면에 표시된 후
	// hide.bs.modal   - modal창이 닫히기 직전
	// hidden.bs.modal - modal창이 닫힌 후 완전히 사라진 시점
	updateModalEl.addEventListener('show.bs.modal', (e) => {
		console.log("ㅎㅎㅎㅎㅎ" ,e)
		// 1. 눌러진 수정 버튼 정보
		const btn  	  = e.relatedTarget;
		let id 				= btn.dataset.bsId       	  // data-bs-id 내가 만든 속성들
		let nickname  = btn.dataset.bsNickname    // data-bs-nickname
		let body		  = btn.dataset.bsBody 			  // data-bs-body
		let articleId = btn.dataset.bsArticleId   // data-bs-article-id
		
		// modal창에 출력한다
	  document.querySelector('#update-article-id').value = articleId
		document.querySelector('#update-id').value = id
		document.querySelector('#update-nickname').value = nickname
		document.querySelector('#update-body').value = body
		
	})
	
	// 삭제 모달창 찾기
	const deleteModalEl = document.querySelector('#deleteModal')
	const deleteModalTitleEl = document.querySelector('#delete-modal-id')
	deleteModalEl.addEventListener('show.bs.modal', (a) => {
		console.log('ㅋㅋㅋㅋㅋㅋ',a)
		let id = a.relatedTarget.dataset.bsId;
		let nickname  = a.relatedTarget.dataset.bsNickname
		let body		  = a.relatedTarget.dataset.bsBody
		let articleId = a.relatedTarget.dataset.bsArticleId
		document.querySelector('#delete-id').value = id;
		deleteModalTitleEl.innerHTML = `(${id}번 댓글) ${nickname}님 의 댓글`; //span에 댓글 번호 넣기
		console.log("ㄴㄴㄴㄴㄴㄴㄴㄴㄴ",deleteModalTitleEl.value)
	})



