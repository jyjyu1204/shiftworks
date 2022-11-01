<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/task.js"></script>
<link rel="stylesheet" href="/resources/css/task.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>업무 관리</title>
</head>
<body>

	<div class="newContainer">
		<div class="mb-3">
			<label for="task_id" class="form-label">글 번호</label>
			<input type="text" class="form-control" value="${task.task_id}"
			id="task_id" readonly>
		</div>
		<div class="mb-3">
		<!-- 부서 검색 가능하도록 변경 필요 -->
			<label for="dept_name" class="form-label">부서</label>
			<input type="text" class="form-control"
			id="dept_name" value="${task.dept_name}" readonly>
			<input type="hidden" class="form-control"
			id="dept_id" value="${task.dept_id}">
		</div>
		<div class="mb-3">
			<label for="task_title" class="form-label">제목</label>
			<input type="text" class="form-control" value="${task.task_title}"
			id="task_title" placeholder="글 제목" readonly>
		</div>
		<div class="mb-3">
			<label for="name" class="form-label">작성자</label>
			<input class="form-control" type="text" value="${task.name}"
				id="name" readonly>
			<input class="form-control" type="hidden" value="${task.emp_id}"
				id="emp_id">
		</div>
		<div class="mb-3 form-check">
			<div>
				<input class="form-check-input" type="radio" name="t_private"
					id="t_private1" checked> <label
					class="form-check-label" for="t_private1"> 전체공개 </label>
			</div>
			<div>
				<input class="form-check-input" type="radio" name="t_private"
					id="t_private2"> <label class="form-check-label"
					for="t_private2"> 부서원에게만 공개 </label>
			</div>
		</div>
		<div class="mb-3">
			<label for="task_content" class="form-label">내용</label>
			<textarea class="form-control" id="task_content" rows="10" readonly>
				<c:out value="${task.task_content}"></c:out>
			</textarea>
		</div>
		<div class="mb-3">
			<label for="formFileSm" class="form-label file">첨부파일</label>
			<input class="form-control form-control-sm" id="formFileSm" type="file" readonly>
		</div>
		<div class="confirm">
			<button id="updateBtn" type="submit" class="btn btn-warning mb-3">수정</button>
			<button id="updateSubmitBtn" type="submit" class="btn btn-warning mb-3">수정완료</button>
			<button id="deleteBtn" type="submit" class="btn btn-danger mb-3">삭제</button>
			<button id="resetBtn" type="reset"
				class="btn btn-outline-primary mb-3">취소</button>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			
			// 게시글 상세 페이지 접속 시 공개여부 라디오버튼 숨김
			$('.form-check *').hide();
			// 수정 완료 게시글 버튼 숨김
			$('#updateSubmitBtn').hide();
			
			// 게시글 수정 버튼 클릭 이벤트
			$('#updateBtn').on("click", function(){
				
				// 수정 버튼 클릭 시 수정 가능한 사항들을 입력(수정) 가능한 상태로 바꿈
				$('.form-check *').show();
				$('#dept_id').attr("readonly", false);
				$('#task_title').attr("readonly", false);
				$('#task_content').attr("readonly", false);
				
				// '수정' 버튼을 '수정 완료' 버튼으로 변경
				$('#updateBtn').hide();
				$('#updateSubmitBtn').show();
				
				
			}) // end update click
			
			// 수정 완료 버튼 클릭 시 이벤트
			$('#updateSubmitBtn').on("click", function(e) {
				e.preventDefault();
				
				// 항목 체크에 따른 값 저장
				let isPrivate;
				if($('#t_private1').is(":checked")) {
					isPrivate = 'Y';
				} else {
					isPrivate = 'N';
				}
				
				// 폼 입력값 객체에 대입
				var updateTask = {
					dept_id: $('#dept_id').val(),
					task_title: $('#task_title').val(),
					task_content: $('#task_content').val(),
					t_private: isPrivate,
					task_id: $('#task_id').val(),
					type: 'empty',
					keyword: 'empty',
					pageNum: 1
				}

				// 객체 전달하여 DB에 저장 후 페이지 이동
				taskService.updateTask(updateTask, function(result){
					// href 대신 replace 이용하여 히스토리 남지 않게 처리
					location.replace("/task/pages/" + updateTask.dept_id + "/" + updateTask.type + "/" + updateTask.keyword
				            + "/" + updateTask.pageNum + "/" + updateTask.task_id);
				});

			}); // end update data submit click event
			
			// 삭제 버튼 클릭 시 이벤트
			$('#deleteBtn').on("click", function(){
				
				taskService.deleteTask($('#task_id').val(), function(result) {
					location.replace("/task/pages/" + $('#dept_id').val() + "/empty/empty/1");
				}); 
				
			}); // end delete click
			
			
			
			// 취소 버튼 클릭 시 이전 페이지(업무 목록)로 이동
			$('#resetBtn').on("click", function(){
				
				history.back();
				
			}); // end reset click event

		}); // end document ready function
	</script>

</body>
</html>