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
					<li>
						<p>
							홍길동님 반갑습니다 <i class="xi-angle-down-min xi-x"></i>
						</p>
						<div class="user_choice">
							<ul>
								<li><a href="">수강정보</a></li>
								<li><a href="">성적정보</a></li>
								<li><a href="">회원정보 변경</a></li>
							</ul>
						</div>
					</li>
					<li class="last"><a href="login_out" class="login_out">로그아웃</a>
					</li>
				</ul>
			</div>
		</header>
		<div class="containers">
			<section class="container_left">
				<nav>
					<ul>
						<li><a href="">학생관리</a></li>
						<li><a href="">성적관리</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right container_center">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보" />
					<h4>성적정보</h4>
				</div>
				<div class="container mt-3">
					<div>
						과목 <select class="form-select form-select-sm"
							style="width: 500px; display: inline;" name="subjectSelect" onchange="location.href=this.value">
							<c:forEach var="subject" items="${subjectList}">
								<option value="${subject.subno}">[${subject.subno}]${subject.name}[${subject.start}~${subject.end}]</option>
							</c:forEach>
						</select>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>No</th>
								<th>학번</th>
								<th>이름</th>
								<th>전공</th>
								<th>학년</th>
								<th>성적입력</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${studentList}">
								<tr>
									<td>${student.regno}</td>
									<td>${student.sno}</td>
									<td>${student.name}</td>
									<td>${student.dname}</td>
									<td>${student.grade}</td>
									<td><select class="form-select form-select-sm"
										style="width: 100px; display: inline;">
											<!-- DB에서 점수 받아와서 선택하기 -->
											<option>A+</option>
											<option>A</option>
											<option>A-</option>
											<option>B+</option>
											<option>B</option>
											<option>B-</option>
											<option>C+</option>
											<option>C</option>
											<option>C-</option>
											<option>F</option>
									</select> register.score
										<button>저장</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pagination justify-content-center">
						<li class="page-item"><a class="page-link"
							href="javascript:void(0);">Previous</a></li>
						<li class="page-item"><a class="page-link"
							href="javascript:void(0);">1</a></li>
						<li class="page-item"><a class="page-link"
							href="javascript:void(0);">2</a></li>
						<li class="page-item"><a class="page-link"
							href="javascript:void(0);">Next</a></li>
					</ul>
				</div>
			</section>

		</div>
	</div>

</body>
</html>