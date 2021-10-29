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
					<li class="last">
						<c:if test="${member != null}">
							${member.name}님 반갑습니다.<i class="xi-angle-down-min xi-x"></i>
							<div class="user_choice">
							<ul>
								<li><a href="manager_mylogin">회원정보변경</a></li>
								
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
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />학생관리</a></li>
						<li><a href="student_search">-학생검색</a></li>
						<li><a href="student_insert">-학생등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />교수관리</a></li>
						<li><a href="professor_search">-교수검색</a></li>
						<li><a href="professor_insert">-교수등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />강의관리</a></li>
						<li><a href="subject_search">-강의검색</a></li>
						<li><a href="subject_insert">-강의등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />공지사항관리</a></li>
						<li><a href="manager_notice">-공지사항검색</a></li>
						<li><a href="manager_notice_insert">-공지사항등록</a></li>

					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="성적정보" />
					<h4>강의검색</h4>
				</div>
				<div class="search_box">
					<div class="search">
						
						<form method="post" action="subject_searchNS">
						<input type="text" name="p_name" placeholder="담당교수 검색" />
							<input type="text" name="name" placeholder="과목명 검색" />
							<input type="submit" class="btn btn-outline-dark" value="검색" /><br>
						</form>
					</div>

				</div>
				<c:if test="${!empty subjectList}">
					<div class="container_score">
						<table class="table table-hover">
							<colgroup>
								<col style="width: 20%">
								<col style="width: 20%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								
							</colgroup>
							<thead>
								<tr>
									<th>과목코드</th>
									<th>과목명</th>
									<th>담당교수</th>
									<th>학점</th>
									<th>강의시간</th>
									<th>상태</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="subject" items="${subjectList}">

									<tr>
										<td><a href='subject_detail?subno=${subject.subno}' style="color:blue">${subject.subno}</a></td>
										<td>${subject.name}</td>
										<td>${subject.p_name}</td>
										<td>${subject.score}</td>
										<td>${subject.date}</td>
										<td>${subject.state}</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</c:if>
			</section>
		</div>
	</div>

</body>
</html>
