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
				<form method="post" action="manager_user_update">
					<div class="my_login">
						<h3 class="title">회원정보 변경</h3>
						<div class="my_center">
							<div class="my_text_edit">
								<label>아이디</label><input type="text" class="login_text dis" name="id" value="${manager.id}" readonly/>
							</div>
							<div class="my_text_edit">
								<label>이름</label><input type="text" class="login_text" name="name" value="${manager.name}" />
							</div>
							<div class="my_text_edit">
								<label>비밀번호</label><input type="password" class="login_text" value="${manager.password}"/>
							</div>
							<div class="my_text_edit">
								<label>새 비밀번호</label><input type="password" class="login_text" name="password" />
							</div>
							<div class="my_text_edit">
								<label>연락처</label><input type="text" class="login_text" name="tel" value="${manager.tel}"/>
							</div>
							<div class="my_text_edit">
								<label>이메일 </label><input type="text" class="login_text2"
									name="email1" value="${email1}" />@ <select
									class="login_select" name="email3">
									<option value="${email2}" hidden="hidden">${email2}</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
								</select>
							</div>
							<div class="my_adr">
								<div class="my_text_edit">
									<label>주소</label>
									<div class="my_adr_search">
										<input type="text" id="sample6_postcode" placeholder="우편번호"
											class="login_text login_text3"> <input type="button"
											onclick="sample6_execDaumPostcode()" value="찾기"
											class="btn_adr"><br>
									</div>
								</div>
								<div class="my_right">
									<input type="text" id="sample6_address" class="login_text big"
										placeholder="주소" name="address" value="${student.address}">
									<input type="text" id="sample6_detailAddress"
										class="login_text big" placeholder="상세주소"> <input
										type="text" id="sample6_extraAddress" class="login_text big"
										placeholder="참고항목">
								</div>
							</div>
							<div class="my_btn">
								<input type="button" class="btn_can" value="취소"/>
								<input type="submit" class="btn_edit" value="수정"/>
							</div>
						</div>
					</div>
				</form>
			</section>
			
		</div>
	</div>
	
</body>
</html>
