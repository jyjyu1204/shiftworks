<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script 
	src="https://code.jquery.com/jquery-3.4.1.js"></script>
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