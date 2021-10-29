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
						<li class="menu_active"><a href="">수강신청</a></li>
						<li><a href="">교수정보</a></li>
						<li><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보"/>
					<h4>수강신청</h4>
				</div>
<<<<<<< HEAD
=======
				<form method="post" action="student_subject_select">
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
				<div class="search_box">
					<div class="search">
						<label>학년</label>
						<select class="search_select">
							<option value="0">전체</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
						<div style="margin-left:20px;">
							<label for="major">
								<input type="radio" id="major" checked/> 전공
							</label>
							<label for="subject">
								<input type="radio" id="subject" /> 교양
							</label>
						</div>
					</div>
					<div>
						<input type="submit" class="btn_edit" value="조회"/>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:5%">
					          <col style="width:10%">
					          <col style="width:5%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					        </colgroup>
					 		<thead>
					 			<tr>
					 				<th>No</th>
					 				<th>과목</th>
					 				<th>학년</th>
					 				<th>개강일</th>
					 				<th>종강일</th>
					 				<th>학점</th>
					 				<th>강의시간</th>
					 				<th>담당교수</th>
					 				<th>강의실</th>
					 				<th>인원수</th>
					 				<th>신청인원</th>
					 				<th>신청</th>
					 			</tr>
					 		</thead>
					 		<tbody>
					 			<tr>
					 				<td>2</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td>1</td>
					 				<td>컴퓨터 와 이해</td>
					 				<td>1</td>
					 				<td>2021.03.12</td>
					 				<td>2021.06.12</td>
					 				<td>3</td>
					 				<td>월5,수6,7</td>
					 				<td>김판수</td>
					 				<td>A09</td>
					 				<td>30</td>
					 				<td>25</td>
					 				<td>
					 					<input type="submit" class="btn_edit btn_cancle" value="신청"/>
					 				</td>
					 			</tr>
					 	</table>
				</div>
				<div class="paging">
					<ul>
						<li><</li>
						<li>1</li>
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
