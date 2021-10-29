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
					<li>
						<p>${member.name}님 반갑습니다 <i class="xi-angle-down-min xi-x"></i></p>
						<div class="user_choice">
							<ul>
								<li><a href="">수강정보</a></li>
								<li><a href="student_score">성적정보</a></li>
								<li><a href="student_mylogin">회원정보 변경</a></li>
							</ul>
						</div>
					</li>
					<li class="last">
						<a href="logout" class="login_out">로그아웃</a>
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
						<li class="menu_active"><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="메인"/>
					<h4>공지사항</h4>
				</div>
				
				<div class="container_score">
					<table class="table table_bg">
					 		<colgroup>
					          <col style="width:15%">
					          <col style="width:35%">
					          <col style="width:15%">
					          <col style="width:35%">
					        </colgroup>
					 		<tbody>
					 			<tr>
					 				<th>작성일</th>
					 				<td>${notice.time}</td>
					 				<th>조회수</th>
					 				<td>${notice.views}</td>
					 			</tr>
					 			<tr>
					 				<th>작성일</th>
					 				<td colspan="3">${notice.subject}</td>
					 			</tr>
					 			<tr>
					 				<td colspan="4">
						 				<p>${notice.contents}</p>
					 				</td>
					 			</tr>
					 		</tbody>
					 </table>
				</div>
				<div class="my_btn">
							<input type="button" class="btn_edit" onclick="location.href='notice'" value="목록"/>
						</div>
			</section>
		</div>
	</div>
	
</body>
</html>