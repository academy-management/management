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
								<li><a href="">수강정보</a></li>
								<li><a href="student_score">성적정보</a></li>
								<li><a href="student_mylogin">회원정보 변경</a></li>
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
						<li><a href="">수강신청</a></li>
						<li class="menu_active"><a href="">교수정보</a></li>
						<li><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="정보"/>
					<h4>교수정보</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<label>학과</label>
						<select class="search_select">
							<option value=11">컴퓨터공학과</option>
							<option value="12">행정과</option>
							<option value="22">법학과</option>
							<option value="33">시각 디자인과</option>
						</select>
					</div>
					<div>
						<input type="submit" class="btn_edit" value="조회"/>
					</div>
				</div>
				<div class="container_score border_d">
					<div class="professor_box">
						<div class="p_bg"></div>
						<div class="p_text">
							<h5>김판수</h5>
							<p>대표 : 컴퓨터 공학과</p>
							<p>email : dafsdf@gmail.com</p>
							<p>연락처 : 010-4567-7894</p>
							<p>연구실 : 서울시 은평구 00 0000</p>
						</div>
						<div class="p_text">
							<h5>담당과목</h5>
							<p>컴퓨터 공학과</p>
							<p>역사와 이해</p>
							<p>이론과 실습</p>
						</div>
					</div>
				</div>
				<div class="paging">
					<ul>
						<li><</li>
						<li class="active">1</li>
						<li>2</li>
						<li>3</li>
						<li>4</li>
						<li>5</li>
						<li>></li>
					</ul>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>
