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
<link rel="stylesheet" href="../css/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/slick.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#">
						<img src="../img/logo.png" alt="메인"/>
					</a>
				</h1>
			</div>
			<div class="user">
				<ul>
					<li>
						<p>홍길동님 반갑습니다  <i class="xi-angle-down-min xi-x"></i></p>
						<div class="user_choice">
							<ul>
								<li><a href="">수강정보</a></li>
								<li><a href="">성적정보</a></li>
								<li><a href="">회원정보 변경</a></li>
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
			<section class="container_right container_center">
				<div class="my_login">
					<h3 class="title">교수 등록</h3>
					<div class="my_center">
						<form method="post" action="professor_insert">
						<div class="my_text_edit">
							<label>교수번호</label><input type="text" class="login_text dis" name="pno"/>
						</div>
						<div class="my_text_edit">
							<label>비밀번호</label><input type="password" class="login_text" name="password"/>
						</div>
						<div class="my_text_edit">
							<label>이름</label><input type="text" class="login_text" name="name" />
						</div>
						<div class="my_text_edit" style="margin-bottom:20px">
							<label>소속학과</label>
							<select class="login_text" name="d_name">
									<option value="1">컴퓨터공학과</option>
									<option value="2">기계공학과</option>
							</select>
						</div>
						<div class="my_text_edit">
							<label>전공</label><input type="text" class="login_text" name="major" />
						</div>
						<div class="my_text_edit">
							<label>연구실</label><input type="text" class="login_text" name="pro_room" />
						</div>
						<div class="my_text_edit">
							<label>연락처</label><input type="text" class="login_text" name="tel" />
						</div>
						<div class="my_text_edit">
							<label>이메일</label><input type="text" class="login_text2" name="email" />@
							<select class="login_select">
								<option>선택해주세요</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
							</select>
						</div>
						<div class="my_adr">
							<div class="my_text_edit">
								<label>주소</label>
								<div class="my_adr_search">
									<input type="text" id="sample6_postcode" placeholder="우편번호" class="login_text login_text3" name="address">
									<input type="button" onclick="sample6_execDaumPostcode()" value="찾기" class="btn_adr"><br>
								</div>
							</div>
							<div class="my_right">
								<input type="text" name="address2" id="sample6_address" class="login_text big"  placeholder="주소">
								<input type="text" name="address3" id="sample6_detailAddress" class="login_text big" placeholder="상세주소">
								<input type="text" name="address4" id="sample6_extraAddress" class="login_text big" placeholder="참고항목">
							</div>
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
