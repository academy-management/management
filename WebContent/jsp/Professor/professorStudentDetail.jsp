<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="/Academic-Management/css/style.css" type="text/css">

<script src="https://code.jquery.com/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic-Management/js/script.js"></script>
<script type="text/javascript" src="/Academic-Management/js/slick.js"></script>

</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#"> <img src="/Academic-Management/img/logo.png" alt="메인" />
					</a>
				</h1>
			</div>
			<div class="user">
				<ul>
					<li class="last">
						<c:if test="${member != null}">
							${member.name}님 반갑습니다.<i class="xi-angle-down-min xi-x"></i>
							<div class="user_choice">
							<ul>
							<li><a href="professorLectureInfo">강의정보</a></li>
								<li><a href="professorMylogin">회원정보 변경</a></li>
							</ul>
						</div>
							<a href="logout" class="login_out">로그아웃</a>
						</c:if>
					</li>
				</ul>
			</div>
		</header>
		<div class="containers">
			<section class="container_left">
				<nav>
					<ul>
						<li><a href="studentSearch">학생관리</a></li>
						<li><a href="studentScoreManage">성적관리</a></li>
						<li><a href="professorNotice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right container_center">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보" />
					<h4>학생정보</h4>
				</div>
				<div class="container mt-3">
					<table class="table table-striped">
						<tr>
							<td><b>학번</b></td>
							<td>${student.sno}</td>
							<td><b>성명</b></td>
							<td>${student.name}</td>
						</tr>
						<tr>
							<td><b>연락처</b></td>
							<td>${student.tel}</td>
						</tr>
					</table>
					<table class="table table-striped">
						<tr>
							<td><b>학과</b></td>
							<td>${student.dname}</td>
							<td><b>학년</b></td>
							<td>${student.grade}</td>
						</tr>
						<tr>
							
							<td><b>재학상태</b></td>
							<td>${student.state}</td>
						</tr>
						<tr>							
							<td><b>주소</b></td>
							<td>${student.address}</td>
							<td><b>E-mail</b></td>
							<td>${student.email}</td>
						</tr>
					</table>
					<button type="button" class="btn btn-primary btn-lg"
						onclick="location.href='studentSearch' ">뒤로</button>
				</div>
			</section>

		</div>
	</div>


</body>
</html>