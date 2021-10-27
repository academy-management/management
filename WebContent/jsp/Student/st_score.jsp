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
						<li><a href="">수강신청</a></li>
						<li><a href="">교수정보</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보"/>
					<h4>성적정보</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<label>학년/학기</label>
						<select class="search_select">
							<option value="2021">2021</option>
							<option value="2021">2021</option>
							<option value="2021">2021</option>
							<option value="2021">2021</option>
							<option value="2021">2021</option>
						</select>
						<select class="search_select">
							<option value="1">1학기</option>
							<option value="2">2학기</option>
						</select>
					</div>
					<div>
						<input type="submit" class="btn_edit" value="수정"/>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:30%">
					          <col style="width:10%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					        </colgroup>
					 		<thead>
					 			<tr>
					 				<th>과목</th>
					 				<th>학점</th>
					 				<th>개강일</th>
					 				<th>종강일</th>
					 				<th>담당교수</th>
					 				<th>성적확인</th>
					 			</tr>
					 		</thead>
					 		<tbody>
					 			<tr>
					 				<td>컴퓨터 와 이해</td>
					 				<td>3</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>김판수</td>
					 				<td>B+</td>
					 			</tr>
					 			<tr>
					 				<td>컴퓨터 와 이해</td>
					 				<td>3</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>김판수</td>
					 				<td>B+</td>
					 			</tr>
					 	</table>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>
