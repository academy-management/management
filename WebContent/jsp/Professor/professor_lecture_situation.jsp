<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
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
							<li><a href="professorLectureInfo">강의정보</a></li>
								<li><a href="professorMylogin">회원정보 변경</a></li>
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
						<li><a href="studentSearch">학생관리</a></li>
						<li><a href="studentScoreManage">성적관리</a></li>
						<li><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="강의정보"/>
					<h4>강의 수강 현황</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<h6>[${subject.subno}] ${subject.name} (${subject.start} - ${subject.end})</h6>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:10%">
					          <col style="width:15%">
					          <col style="width:10%">
					          <col style="width:20%">
					          <col style="width:25%">
					        </colgroup>
					 		<thead>
					 			<tr>
					 				<th>No</th>
									<th>학번</th>
									<th>이름</th>
									<th>전공</th>
									<th>학년</th>
									<th>전화번호</th>
									<th>Email</th>
					 			</tr>
					 		</thead>
					 		<tbody>
								<c:forEach var="student" items="${studentList}" varStatus="status">
									<tr>
										<td>${fn:length(studentList) - status.index}</td>
										<td>${student.sno}</td>
										<td>${student.name}</td>
										<td>${student.d_name}</td>
										<td>${student.grade}</td>
										<td>${student.tel}</td>
										<td>${student.email}</td> 
									</tr>
								</c:forEach>
							</tbody>
					 	</table>
				</div>
				<div class="paging">
					<ul>
						<c:if test="${pageGroupResult.beforePage}">
							<li>
								<a href="#"><</a>
							</li> 
						</c:if>
						
						<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
							<c:choose>
								<c:when test="">
									<li>
										<a href="#">${index}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="#">${index}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pageGroupResult.afterPage}">
							<li>
								<a href="#"> > </a>
							</li> 
						</c:if>
					</ul>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>