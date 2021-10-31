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
						<li><a href="#"><img src="/Academic-Management/img/title_img.png" alt="성적정보" />학생관리</a></li>
						<li><a href="student_search">-학생검색</a></li>
						<li><a href="student_insert">-학생등록</a></li>
						<li><a href="#"><img src="/Academic-Management/img/title_img.png" alt="성적정보" />교수관리</a></li>
						<li><a href="professor_search">-교수검색</a></li>
						<li><a href="professor_insert">-교수등록</a></li>
						<li><a href="#"><img src="/Academic-Management/img/title_img.png" alt="성적정보" />강의관리</a></li>
						<li><a href="subject_search">-강의검색</a></li>
						<li><a href="subject_insert">-강의등록</a></li>
						<li><a href="#"><img src="/Academic-Management/img/title_img.png" alt="성적정보" />공지사항관리</a></li>
						<li><a href="manager_notice">-공지사항검색</a></li>
						<li><a href="manager_notice_insert">-공지사항등록</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right container_center">
				<div class="my_login">
					<h3 class="title">강의 등록</h3>
					<div class="my_center">
					<form method="post" action="subject_insert">
						<div class="my_text_edit">
							<label>과목코드</label><input type="text" class="login_text dis" name="subno"/>
						</div>
						<div class="my_text_edit">
							<label>과목명</label><input type="text" class="login_text" name="name"/>
						</div>
						<div class="my_text_edit" style="margin-bottom:20px">
							<label>교수명</label>
							<select class="login_text" name="pno">
									<option value="p001">백시우 교수</option>
									<option value="p002">양호성 교수</option>
									<option value="p003">권상미 교수</option>
									<option value="p004">황보민선 교수</option>
									<option value="p005">노지은 교수</option>
							</select>
						</div>
						
						<div class="my_text_edit">
							<label>학년</label><input type="text" class="login_text" name="grade" />
						</div>
						<div class="my_text_edit">
							<label>학점</label><input type="text" class="login_text" name="score" />
						</div>
						<div class="my_text_edit">
							<label>강의실</label><input type="text" class="login_text" name="room" />
						</div>
						<div class="my_text_edit">
							<label>인원수</label><input type="text" class="login_text" name="people" />
						</div>
						<div class="my_text_edit" style="margin-bottom:20px">
							<label>강의요일</label>
							<select class="login_text" name="week">
									<option value="월요일">월요일</option>
									<option value="화요일">화요일</option>
									<option value="수요일">수요일</option>
									<option value="목요일">목요일</option>
									<option value="금요일">금요일</option>
									<option value="토요알">토요일</option>
									<option value="일요일">일요일</option>
							</select>
						</div>
						<div class="my_text_edit" style="margin-bottom:20px">
							<label>강의시간</label>
							<select class="login_text2" name="time">
									<option value="1">9:30 [1교시]</option>
									<option value="2">10:30 [2교시]</option>
									<option value="3">11:30 [3교시]</option>
									<option value="4">12:30 [4교시]</option>
									<option value="5">13:30 [5교시]</option>
									<option value="6">14:30 [6교시]</option>
									<option value="7">15:30 [7교시]</option>
									<option value="8">16:30 [8교시]</option>
									<option value="9">17:30 [9교시]</option>
									<option value="10">18:30 [10교시]</option>								
							</select>~
							<select class="login_text2" name="time2">
										<option value="1">9:30 [1교시]</option>
									<option value="2">10:30 [2교시]</option>
									<option value="3">11:30 [3교시]</option>
									<option value="4">12:30 [4교시]</option>
									<option value="5">13:30 [5교시]</option>
									<option value="6">14:30 [6교시]</option>
									<option value="7">15:30 [7교시]</option>
									<option value="8">16:30 [8교시]</option>
									<option value="9">17:30 [9교시]</option>
									<option value="10">18:30 [10교시]</option>
							</select>
						</div>
						<div class="my_text_edit" >
							<label>강의날짜</label>
							<input type="date" class="login_text2" name="startday" />
							~
							<input type="date" class="login_text2" name="endday" />
						</div>
						
						<div class="my_text_edit" style="margin-bottom:20px">
							<label>구분</label>
							<select class="login_text" name="division">
									<option value="전공">전공</option>
									<option value="교양">교양</option>
							</select>
						</div>
						
						<div class="my_text_edit">
							<label>학과</label>
							<select class="login_text" name="department">							
									<option value="0">교양</option>
									<option value="1" selected>컴퓨터공학과</option>
									<option value="2" >경영학과</option>
									<option value="3" >화학과</option>
							</select>
						</div>
						<div class="my_btn">
							<input type="reset" class="btn_can" value="취소"/>
							<input type="submit" class="btn_edit" value="등록"/>
						</div>
						</form>
					</div>
				</div>
			</section>
			
		</div>
	</div>
	
</body>
</html>
