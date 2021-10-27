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
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
						<li><a href="student_search">-학생검색</a></li>
						<li><a href="student_insert">-학생등록</a></li>
						<li><a href="">교수관리</a></li>
						<li><a href="professor_search">-교수검색</a></li>
						<li><a href="professor_insert">-교수등록</a></li>
						<li><a href="">강의관리</a></li>
						<li><a href="subject_search">-강의검색</a></li>
						<li><a href="subject_insert">-강의등록</a></li>
						<li><a href="">공지사항관리</a></li>
						<li><a href="">-공지사항검색</a></li>
						<li><a href="">-공지사항등록</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="성적정보" />
					<h4>학생검색</h4>
				</div>
				<div class="search_box">
					<div class="search">

						<form method="post" action="student_searchbyname">
							<select name="year">
								<option value="">입학년도</option>
								<option value="2021">2021</option>
								<option value="2020">2020</option>
								<option value="2019">2019</option>
							</select> <select name="department">
								<option value="">전공</option>
								<option value="컴퓨터공학">컴퓨터공학</option>
								<option value="기계공학">기계공학</option>
								<option value="전기공학">전기공학</option>
							</select> <input type="text" name="name" placeholder="이름 검색"/><input
								type="submit" class="btn btn-outline-dark" value="검색" /><br>
						</form>
					</div>

				</div>
				<c:if test="${!empty studentList}">
					<div class="container_score">
						<table class="table table-hover">
							<colgroup>
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 10%">
							</colgroup>
							<thead>
								<tr>
									<th>학번</th>
									<th>이름</th>
									<th>입학년도</th>
									<th>전공</th>
									<th>핸드폰번호</th>
									<th>상태</th>
									<th>상태수정</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="student" items="${studentList}">

									<tr>
										<form method="post" action="student_update">
										<td><input type="hidden" name="sno" value=${student.sno
											} readonly />${student.sno}</td>
										<td>${student.name}</td>
										<td>${student.year}</td>
										<td>${student.d_name}</td>
										<td>${student.tel}</td>
										<td>
										<c:if test="${student.state == '재학'}"> 
										<select name="state">
												<option value="${student.state}">${student.state}</option>
												<option value="휴학">휴학</option>
												<option value="퇴학">퇴학</option>
										</select>
										</c:if>
										
										<c:if test="${student.state == '휴학'}"> 
										<select name="state">
												<option value="${student.state}">${student.state}</option>
												<option value="재학">재학</option>
												<option value="퇴학">퇴학</option>
										</select>
										</c:if>
										
										<c:if test="${student.state == '퇴학'}"> 
										<select name="state">
												<option value="${student.state}">${student.state}</option>
												<option value="재학">재학</option>
												<option value="휴학">휴학</option>
										</select>
										</c:if>
										
										</td>
										<td><input type="submit" class="btn btn-outline-dark" value="수정" /></td>
										</form>
									</tr>
								</c:forEach>
						</table>
					</div>
				</c:if>
				<c:if test="${empty studentList}">
				없습니다.
				</c:if>
			</section>
		</div>
	</div>

</body>
</html>
