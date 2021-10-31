<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="/Academic-Management/css/style.css"
	type="text/css">

<script src="https://code.jquery.com/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic-Management/js/script.js"></script>
<script type="text/javascript" src="/Academic-Management/js/slick.js"></script>
<script>
$(document).ready(function(){
	var searchSelect = $('#yearSelected').val();
	if(searchSelect != ""){
		$('select[name="yearSelect"]').val(searchSelect).prop("selected", true);
	}
	
});
</script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#"> <img src="/Academic-Management/img/logo.png" alt="메인" />
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
						<li><a href="professorNotice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right container_center">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="학생관리" />
					<h4>학생 관리</h4>
				</div>
				<div class="container mt-3">
					<form method="get" action="" style="">						
						<div>
							입학년도 
							<input type="hidden" id="yearSelected" value="${yearSelected}">							
							<select class="form-select form-select-sm year" style="width: 100px; display: inline;" id="yearSelect" name="yearSelect">
								<option value="21">2021</option>
								<option value="20">2020</option>
								<option value="19">2019</option>
								<option value="18">2018</option>
							</select> <span>이름</span> 
							<input type="text" placeholder="검색할 학생이름을 입력하세요" name="nameSearch"> 
							<input type="submit" formaction="studentSearch" value="학년도 전체조회">
							<input type="submit" formaction="studentNameOrYearSearch" value="이름/학년도 조회">
						</div>
					</form>
					<table class="table">
						<thead>
							<tr>
								<th>학번</th>
								<th>이름</th>
								<th>전공</th>
								<th>학년</th>
								<th>재학상태</th>
								<th>보기</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="std" items="${studentList}">
								<tr>
									<td>${std.sno}</td>
									<td>${std.name}</td>
									<td>${std.dname}</td>
									<td>${std.grade}</td>
									<td>${std.state}</td>
									<td><a href="studentDetail?sno=${std.sno}" style="color:blue; text-decoration: underline;">상세보기</a></td>
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