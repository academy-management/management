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
								<li><a href="student_class">수강정보</a></li>
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
						<li><a href="student_application">수강신청</a></li>
						<li><a href="professor_url">교수정보</a></li>
						<li><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="정보"/>
					<h4>교수정보</h4>
				</div>
				<div class="search_box">
					<form method="post" action="professor_searcheds">
						<div class="search">
							<label>학과</label>
							<select class="search_select" name="professor_ch">
								<option value="1">컴퓨터 공학과</option>
								<option value="2">기계 공학과</option>
							</select>
						</div>
						<div>
							<input type="submit" class="btn_edit" value="조회"/>
						</div>
					</form>
				</div>
				<div class="container_score border_d">
					<c:if test="${!empty professorList}">
						<c:forEach var="professorList" items="${professorList}">
							<div class="professor_box">
								<div class="p_bg">
									<i class="xi-face xi-5x"></i> 
								</div>
								<div class="p_text">
									<h5>${professorList.name}</h5>
									<p>전공 : ${professorList.major}</p>
									<p>email : ${professorList.email}</p>
									<p>연락처 : ${professorList.tel}</p>
									<p>연구실 : ${professorList.pro_room}</p>
								</div>
								<!-- <div class="p_text">
									<h5>담당과목</h5>
									<p>컴퓨터 공학과</p>
									<p>역사와 이해</p>
									<p>이론과 실습</p>
								</div> -->
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty professorList}">
							 <hr />  
							 <p class="center">등록된 교수님이 없습니다.</p>
									 <hr />  
						</c:if>
				</div>
				<div class="paging">
					<ul>
						<c:if test="${pageGroupResult.beforePage}">
							<li>
								<a href="professor?reqPage=${pageGroupResult.groupStartNumber-1}"><</a>
							</li> 
						</c:if>
						
						<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
							<c:choose>
								<c:when test="${pageGroupResult.selectPageNumber == index}">
									<li class="active">
										<a href="professor?reqPage=${index}">${index}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="professor?reqPage=${index}">${index}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pageGroupResult.afterPage}">
							<li>
								<a href="professor?reqPage=${pageGroupResult.groupEndNumber+1}">></a>
							</li> 
						</c:if>
					</ul>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>
