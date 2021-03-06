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
					<a href="login">
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
								<li><a href="manager_mylogin">회원정보변경</a></li>
								
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
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />학생관리</a></li>
						<li><a href="student_search">-학생검색</a></li>
						<li><a href="student_insert">-학생등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />교수관리</a></li>
						<li><a href="professor_search">-교수검색</a></li>
						<li><a href="professor_insert">-교수등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />강의관리</a></li>
						<li><a href="subject_search">-강의검색</a></li>
						<li><a href="subject_insert">-강의등록</a></li>
						<li><a href=""><img src="/Academic-Management/img/title_img.png" alt="성적정보" />공지사항관리</a></li>
						<li><a href="manager_notice">-공지사항검색</a></li>
						<li><a href="manager_notice_insert">-공지사항등록</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title_img.png" alt="성적정보"/>
					<h4>공지사항</h4>
				</div>
				<form method="post" action="manager_notice_search" style="vertical-align:middle;">
					<div class="search_box">
						<div class="search" style="display:inline-block;weight:100%">
							<div style="margin-left:20px;">
								<label for="major">
									<select name="division">
									<option value="전체">전체</option>
									<option value="컴퓨터공학과">컴퓨터공학과</option>
									<option value="경영학과">경영학과</option>
									<option value="화학과">화학과</option>
							</select>
								</label>	
							</div>
						</div>
						<div class="notice_btn" style="float:right">
							<input type="text" class="login_text dis hei" name="search" style="float:left" placeholder="제목을 입력하세요"/>
							<input type="submit" class="btn_edit" value="조회"/>	
						</div>
					</div>
				</form>	
				<c:if test="${not empty noticeList}">
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
					 				<th></th>
					 			</tr>
					 		</thead>
					 		<tbody>
					 			<c:forEach var="notice" items="${noticeList}" varStatus="status">
								<tr>
									<td>${fn:length(noticeList) - status.index}</td>
									<td><a href="manager_notice_detail?nno=${notice.nno}">${notice.subject}</a></td>
									<td>${notice.time}</td>
									<td>${notice.views}</td>
									
								</tr>
								</c:forEach>
					 		</tbody>
					 </table>
				</div>
				</c:if>
				<c:if test="${empty noticeList}">
					<br>
					<div style="text-align:center" >
					 	<h6>등록된 공지사항이 없습니다</h6>
					 </div>
				</c:if>
				
				<c:if test="${!empty noticeList}">
				<div class="paging">
					<ul>
						<c:if test="${pageGroupResult.beforePage}">
							<li>
								<a href="manager_notice?reqPage=${pageGroupResult.groupStartNumber-1}"><</a>
							</li> 
						</c:if>
						
						<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
							<c:choose>
								<c:when test="${pageGroupResult.selectPageNumber == index}">
									<li class="active">
										<a href="manager_notice?reqPage=${index}">${index}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="manager_notice?reqPage=${index}">${index}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pageGroupResult.afterPage}">
							<li>
								<a href="manager_notice?reqPage=${pageGroupResult.groupEndNumber+1}">></a>
							</li> 
						</c:if>
					</ul>
				</div>
				</c:if>
				
			</section>
		</div>
	</div>
	
</body>
</html>