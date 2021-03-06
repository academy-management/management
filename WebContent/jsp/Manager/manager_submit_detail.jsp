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
<link rel="stylesheet" href="/Academic-Management/css/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic-Management/js/script.js"></script>
<script type="text/javascript" src="/Academic-Management/js/slick.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#">
						<img src="/Academic-Management/img/logo.png" alt="메인"/>
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
			<section class="container_right container_center">
				<div class="my_login">
					<h3 class="title">강의 수정</h3>
					<div class="my_center">
					
					<form method="post" action="subject_update">
				
						<div class="my_text_edit">
							
							<label>과목코드</label><input type="text" class="login_text dis" name="subno" value="${subject.subno}" readonly/>
							
						</div>
						<div class="my_text_edit">
							<label>과목명</label><input type="text" class="login_text" name="name" value="${subject.name}"/>
						</div>
						
						<div class="my_text_edit">
							<label>학년</label><input type="text" class="login_text" name="grade" value="${subject.grade}"/>
						</div>
						<div class="my_text_edit">
							<label>학점</label><input type="text" class="login_text" name="score" value="${subject.score}"/>
						</div>
						<div class="my_text_edit">
							<label>강의실</label><input type="text" class="login_text" name="room" value="${subject.room}"/>
						</div>
						<div class="my_text_edit">
							<label>인원수</label><input type="text" class="login_text" name="people" value="${subject.people}"/>
						</div>
						<div class="my_text_edit">
							<label>강의요일</label>
							<input type="text" class="login_text" name="date" value="${subject.date}"/>
						</div>
						
												
						<div class="my_text_edit">
							<label>강의상태</label>
							<input type="text" class="login_text" name="state" value="${subject.state}"/>
						</div>
								
						<div class="my_btn">
							
							<input type="submit" class="btn_edit" value="수정"/>
						</div>
			
						</form>
					</div>
				</div>
			</section>
			
		</div>
	</div>
	
</body>
</html>
