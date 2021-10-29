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

<script src="https://code.jquery.com/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/Academic-Management/js/script.js"></script>
<script type="text/javascript" src="/Academic-Management/js/slick.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#"> <img src="/Academic-Management//img/logo.png" alt="메인" />
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
						<li><a href="studentSearch">학생관리</a></li>
						<li><a href="studentScoreManage">성적관리</a></li>
						<li><a href="professorNotice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="성적정보" />
					<h4>공지사항</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<div style="margin-left: 20px;">
							<label for="major"> <input type="radio" id="major"
								checked /> 전체
							</label> <label for="subject"> <input type="radio" id="subject" />
								학과
							</label>
						</div>
					</div>
					<div class="notice_btn">
						<input type="text" class="login_text dis hei" name="search" /> <input
							type="submit" class="btn_edit" value="조회" />
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 70%">
							<col style="width: 10%">
							<col style="width: 10%">
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
							<c:forEach items="${noticeList}" var="noticeList">
								<tr>
									<td>${noticeList.nno}</td>
									<td>${noticeList.subject}</td>
									<td>${noticeList.time}</td>
									<td>${noticeList.views}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="paging">
					<!-- <ul>
						<li><</li>
						<li class="active">1</li>
						<li>2</li>
						<li>3</li>
						<li>4</li>
						<li>5</li>
						<li>></li>
					</ul> -->
					<ul class="pagination pagination-sm">
						<c:if test="${pageGroupReulst.beforePage}">
							<li class="page-item"><a class="page-link"
								href="memo_search?reqPage=${pageGroupReulst.groupStarNumber-1}">이전</a>
							</li>
						</c:if>


						<c:forEach var="index" begin="${pageGroupReulst.groupStarNumber}"
							end="${pageGroupReulst.groyupEndNumber}">
							<c:choose>
								<c:when test="${pageGroupReulst.selectPageNumber==index}">
									<li class="page-item active"><a class="page-link"
										href="memo_search?reqPage=${index}">${index}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="memo_search?reqPage=${index}">${index}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pageGroupReulst.afterPage}">
							<li class="page-item"><a class="page-link"
								href="memo_search?reqPage=${pageGroupReulst.groyupEndNumber+1}">다음
							</a></li>
						</c:if>
					</ul>
				</div>
			</section>
		</div>
	</div>

</body>
</html>
