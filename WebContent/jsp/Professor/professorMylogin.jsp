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
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="/Academic_Management/css/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic_Management/js/script.js"></script>
<script type="text/javascript" src="/Academic_Management/js/slick.js"></script>
 
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#">
						<img src="/Academic_Management/img/logo.png" alt="ë©ì¸"/>
					</a>
				</h1>
			</div>
			<div class="user">
				<ul>
					<li>
						<p>${member.name}님 반갑습니다  <i class="xi-angle-down-min xi-x"></i></p>
						<div class="user_choice">
							<ul>
								<li><a href="professorLectureInfo">강의정보</a></li>
								<li><a href="professorMylogin">회원정보 변경</a></li>
							</ul>
						</div>
					</li>
					<li class="last">
						<a href="login_out" class="login_out">로그아웃</a>
					</li>
				</ul>
			</div>
		</header>
		<div class="containers">
			<section class="container_left">
				<nav>
					<ul>
						<li><a href="">수강신청</a></li>
						<li><a href="">교수정보</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right container_center">
				<div class="my_login">
					<h3 class="title">회원정보 변경</h3>
					<div class="my_center">
					<form method="post" action="professorMypage">
						<input type="password" class="login_text" name="password" placeholder="비밀번호를 입력해주세요">
						<input type="submit" class="btn_submit" value="로그인"/>
					</form>
					</div>
				</div>
			</section>
			
		</div>
	</div>
	
</body>
</html>