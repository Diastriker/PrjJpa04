	// modal 창의 수정 버튼 클릭 - comment-update-btn
	const commentUpdateBtnEl = document.querySelector('#comment-update-btn')
	commentUpdateBtnEl.addEventListener('click', (e) => {
		let comment = {
				id : document.querySelector('#update-id').value,
				article_id : document.querySelector('#update-article-id').value,
				nickname : document.querySelector('#update-nickname').value,
				body : document.querySelector('#update-body').value
		}
		let url = '/api/comments';
		let params = {
				method  : 'PATCH',
				headers : {"Content-Type":"application/json;charset=UTF-8"},
				body    : JSON.stringify(comment)
		}
		fetch(url,params)
		.then( (response) => {
			console.log(response);
			let msg = (response.ok)
				? "댓글이 수정 되었습니다"
				: "댓글 수정 실패"
				alert(msg)
				window.location.reload(); // F5
		} )
	})
	
	// modal 창의 삭제 버튼 클릭 - comment-delete-btn
	const commentDeleteBtnEl = document.querySelector('#comment-delete-btn')
	commentDeleteBtnEl.addEventListener('click', (e) => {
		let deleteId = document.querySelector('#delete-id').value;
		let url = '/api/comments/' + deleteId;
		fetch(url,{
			method : 'DELETE'
		})
			.then( (response) => {
				let msg = (response.ok)
						? "댓글 삭제 성공"
						: "댓글 수정 실패 (섹제 대상이 없습니다)"
				window.location.reload(); // F5
			} )
	})
