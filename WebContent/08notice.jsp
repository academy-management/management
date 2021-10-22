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
<link rel="stylesheet" href="./css/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<script type="text/javascript" src="./js/slick.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#">
						<img src="./img/logo.png" alt="메인"/>
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
					<img src="./img/title_img.png" alt="성적정보"/>
					<h4>공지사항</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<div style="margin-left:20px;">
							<label for="major">
								<input type="radio" id="major" checked/> 전체
							</label>
							<label for="subject">
								<input type="radio" id="subject" /> 학과
							</label>
						</div>
					</div>
					<div class="notice_btn">
						<input type="text" class="login_text dis hei" name="search"/>
						<input type="submit" class="btn_edit" value="조회"/>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:10%">
					          <col style="width:70%">
					          <col style="width:10%">
					          <col style="width:10%">
					        </colgroup>
					 		<thead>
					 			<tr>
					 				<th>No</th>
					 				<th>제목</th>
					 				<th>작성일</th>
					 				<th>조회수</th>
					 			</tr>
					 		</thead>
					 		<tbody>
					 			<tr>
					 				<td>10</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>9</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>8</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>7</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>6</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>5</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>4</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>3</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>2</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>홈페이지 리뉴얼 안내 드립니다.</td>
					 				<td>2021.03.12</td>
					 				<td>100</td>
					 			</tr>
					 		</tbody>
					 </table>
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
