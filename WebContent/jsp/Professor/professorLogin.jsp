<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/Academic_Management/css/style.css" type="text/css">

	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="login_wrap">
		<form method="post" action="professor_login"">
			<div class="login_wraping">
				<h3 class="title">로그인</h3>
				<select class="login_text">
					<option value="st">학생</option>
					<option value="ps">교수</option>
					<option value="ad">관리자</option>
				</select>
				<input type="text" class="login_text" name="pno" placeholder="교번을 입력해주세요">
				<input type="password" class="login_text" name="password" placeholder="비밀번호를 입력해주세요">
				<input type="submit" class="btn_submit" value="로그인"/>
			</div>
		</form>
	</div>
</body>
</html>