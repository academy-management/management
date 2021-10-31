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
<link rel="stylesheet" href="/Academic-Management/css/style.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic-Management/js/script.js"></script>
<script type="text/javascript" src="/Academic-Management/js/slick.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var now = new Date();
	if(now.getMonth() > 9){
		var seme = 2;
	}else{
		var seme = 1;
	}
	
	$("#year_seme").text(now.getFullYear()+"-"+seme);
	
	var searchSelect = $('#subjectSelected').val();
	if(searchSelect != ""){
		$('select[name="subjectSelect"]').val(searchSelect).prop("selected", true);
	}
	
});
var updateScore = function(index) {
	var regno = $('#regno' + index).val();
	var newScore = $('#newScore' + index).val();

	$.get("studentScoreUpdate?regno=" + regno + "&score=" + encodeURIComponent(newScore), function(res) {
		$("#submit").click();
		alert("수정되었습니다");
	});
	
}
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
					<img src="/Academic-Management/img/title.png" alt="성적정보" />
					<h4>성적정보</h4>
				</div>
				<div class="container mt-3">
					<div>					
						<form action="studentScoreManage">
						<input type="hidden" id="subjectSelected" value="${subjectSelected}">
						<h3 id="year_seme" style="display: inline;"></h3><h3 style="display: inline;">학기 성적정보입니다.</h3><br>
							과목 <select class="form-select form-select-sm target" id="subjectSelect" style="width: 500px; display: inline;" name="subjectSelect">
								<option value="null">과목선택</option>
								<c:forEach var="subject" items="${subjectList}">									
									<option value="${subject.subno}">${subject.name}</option>
								</c:forEach>
							</select>
							<input type="submit" value="강의 성적 조회" id="submit">
							
						</form>
					</div>					
						<table class="table">
							<thead>
								<tr>
									<th>No</th>
									<th>학번</th>
									<th>이름</th>
									<th>전공</th>
									<th>학년</th>
									<th>성적입력</th>
								</tr>
							</thead>
							<tbody>							
								<c:forEach var="student" items="${studentList}" varStatus="status">
									<!-- <form action="studentScoreManage"> -->
									<%-- <input type="text" id="subjectSelected" value="${subjectSelected}">	 --%>						
										<tr>
											<td>${student.regno}</td>
											<td>${student.sno}</td>
											<td>${student.name}</td>
											<td>${student.dname}</td>
											<td>${student.grade}</td>
											<td>		
												<select id="newScore${status.index}" class="form-select form-select-sm" style="width: 100px; display: inline;">
													<option value="${student.score}">${student.score}</option>												
													<option value="A+">A+</option>
													<option value="A">A</option>
													<option value="A-">A-</option>
													<option value="B+">B+</option>
													<option value="B">B</option>
													<option value="B-">B-</option>
													<option value="C+">C+</option>
													<option value="C">C</option>
													<option value="C-">C-</option>
													<option value="F">F</option>
												</select>												
												<input type="button" id="save" onclick="updateScore(${status.index})" value="저장">
												<input type="hidden" id="regno${status.index}" value="${student.regno}">
																							
											</td>
										</tr>
										
									<!-- </form> -->
								</c:forEach>
							</tbody>
						</table>	
				</div>
			</section>

		</div>
	</div>

</body>
</html>