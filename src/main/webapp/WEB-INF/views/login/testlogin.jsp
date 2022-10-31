<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<html>
<head>

<script type="text/javascript"></script>
<link rel="stylesheet" href="/resources/css/login.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Shift Works login page</title>
</head>
<body>

	<div class="wrapper">
	<div class="wrap">
		<form id="login_form" method="post">
			<div class="logo_wrap">
				<span>Shift Works</span>
			</div>
			<div class="login_wrap">
				<div class="id_wrap">
					<div class="id_input_box">
						<input class="id_input" name="emp_id">
					</div>
				</div>
				<div class="pw_wrap">
					<div class="pw_input_box">
						<input class="pw_input" name="password">
					</div>
				</div>
				
				<c:if test="${result == 0 }">
					<div class ="login_warn">사번 또는 비밀번호를 잘못 입력하셨습니다.</div>
				</c:if>
				
				<div class="login_button_wrap">
					<input type="button" class="login_button" value="로그인">
				</div>
			</div>
		</form>
		
	</div>
	
</div>

<script>
	/*로그인 버튼 클릭 메서드 */
	$.(".login_button").click(function () {
		
		$("#login_form").attr("action","/user/login");
		$("#login_form").submit();
		
	});
</script>

</body>
</html>