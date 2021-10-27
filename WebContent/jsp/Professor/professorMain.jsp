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
						<li><a href="">수강신청</a></li>
						<li><a href="">교수정보</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right">
				<div class="right_l">
					<div class="main_bnr">
						<img src="/Academic-Management/img/main1.png" alt="ë©ì¸ ë°°ë"/>
					</div>
					<div class="main_notice">
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
					 			<c:forEach var="notice" items="${noticeList}" begin = "0" end= "2">
					 			<tr>
					 				<td>${notice.nno}</td>
					 				<td>${notice.subject}</td>
					 				<td>${notice.time}</td>
					 				<td>${notice.views}</td>
					 			</tr>
					 			</c:forEach>	
					 		</tbody>
					 	</table>
					 </div>
				</div>
				<div class="slide_bnr">
				  	<div id="slider-div">
					    <div>
					    	<img src="/Academic-Management/img/s11.png" alt="ì±ì íì¸ ê¸°ê°"/>
					    </div>
					   <!--  <div>
					    	<img src="./img/s1.png" alt="ì±ì íì¸ ê¸°ê°"/>2222
					    </div> -->
				  	</div>
				</div>
			</section>
			
		</div>
	</div>
	<!-- <script type="text/javascript">
	$(function(){
		$('#slider-div').slick({
			slide: 'div',		
			infinite : true, 	
			slidesToShow : 1,		
			slidesToScroll : 1,		
			arrows : false, 		
			dots : true, 		
			autoplay : true,			
			autoplaySpeed : 1000, 		
			pauseOnHover : true,		
			dotsClass : "slick-dots"	
		});
	})
	</script> -->
</body>
</html>