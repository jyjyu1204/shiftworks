<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shift Works Main page!</title>
</head>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script type="text/javascript"></script>
<body>

	<div class="wrapper">
		<div class="wrap">
			<div class="login_area">
			
				<c:if test="${userDTO != null }">
					<div class="login_success_area">
						<span>사번: ${userDTO.emp_id}</span>
					</div>
				</c:if>
				<div class="clearfix"></div>
			</div>
			<div class="content_area">
				<h1>content area</h1>
			</div>
		</div>
	
	</div>



</body>
</html>                                          