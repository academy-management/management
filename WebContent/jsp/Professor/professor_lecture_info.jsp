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
						<p>${member.name}님 반갑습니다  <i class="xi-angle-down-min xi-x"></i></p>
						<div class="user_choice">
							<ul>
								<li><a href="professorLectureInfo">강의정보</a></li>
								<li><a href="professorMylogin">회원정보 변경</a></li>
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
						<li><a href="">성적관리</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="강의정보"/>
					<h4>강의 정보</h4>
				</div>
				<form method="post" action="professorLectureInfoBySelect">
				<div class="search_box">
					<div class="search">
						<label>연도/학기별</label>
						<select class="search_select" name="year">
							<option value="2021">2021</option>
							<option value="2020">2020</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
							<option value="2015">2015</option>
							<option value="2014">2014</option>
							<option value="2013">2013</option>
							<option value="2012">2012</option>
							<option value="2011">2011</option>
							<option value="2010">2010</option>
						</select>
						<select class="search_select" name="semester">
							<option value="1">1학기</option>
							<option value="2">2학기</option>
						</select>
					</div>
					</form>
					<div>
						<input type="submit" class="btn_edit" value="조회"/>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:10%">
					          <col style="width:20%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					        </colgroup>
					 		<thead>
					 			<tr>
					 				<th>과목코드</th>
									<th>과목</th>
									<th>강의기간</th>
									<th>강의시간</th>
									<th>강의실</th>
									<th>보기</th>
					 			</tr>
					 		</thead>
					 		<tbody>
								<c:forEach var="subject" items="${subjectList}">
									<tr>
										<td>${subject.subno}</td>
										<td>${subject.name}</td>
										<td>${subject.start} - ${subject.end}</td>
										<td>${subject.date}</td>
										<td>${subject.room}</td>
										<td>
											<a href="professorLectureSituation?subno=${subject.subno}">상세보기</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
					 	</table>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>