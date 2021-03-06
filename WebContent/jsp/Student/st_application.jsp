<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<%
	String searchGrade = (String) request.getAttribute("searchGrade");
	String searchDivision = (String) request.getAttribute("searchDivision");
	
	System.out.println(searchGrade);
	System.out.println(searchDivision);
	
%>  
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
<script>
	 $(document).ready(function() {
		var searchGrade = $('#searchGrade').val();
		var searchDivision = $('#searchDivision').val();
		if(searchGrade != '') {
			$('select[name="grade"]').val(searchGrade).prop('selected', true);
		} else {
			$('select[name="grade"]').val('0').prop('selected', true);
		}
		
		$('input[name="division"]').each(function() {
			var value = $(this).val();
			
			if(searchDivision == value) {
				$(this).prop('checked', true);
			}
		});
		
	});
	 
	var goRegist = function(index) {
		var subno = $('#subno' + index).val();
		
		$.get("register_student?subno=" + subno, function(res) {
			if(res == '이미 신청된 과목입니다.') {
				alert(res);
			} else {
				alert(res);
				$('#search').click();
			}
		})
	}
	
	
	
</script>

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
						<li class="menu_active"><a href="student_application">수강신청</a></li>
						<li><a href="professor_url">교수정보</a></li>
						<li><a href="notice">공지사항</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보"/>
					<h4>수강신청</h4>
				</div>
				<form method="post" action="student_subject_select">
				<input type="hidden" id="searchGrade" value="${searchGrade }">
				<input type="hidden" id="searchDivision" value="${searchDivision }">
				<div class="search_box">
					<div class="search">
						<label>학년</label>
						<select class="search_select" name="grade">
							<option value="0">전체</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
						<div style="margin-left:20px;">
							<label for="major">
								<input type="radio" name="division" id="major" value="전공"/> 전공
							</label>
							<label for="subject">
								<input type="radio" name="division" id="subject" value="교양"/> 교양
							</label>
						</div>
					</div>
					<div>
						<input type="submit" class="btn_edit" id="search" value="조회"/>
					</div>
				</div>
				</form>				
					
				<div class="container_score">
					<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보"/>
					<h4>신청목록</h4>
				</div>
					<c:if test="${!empty registerList}">
						<table class="table table-bordered table-sm">
						 		<colgroup>
						          <col style="width:30%">
						          <col style="width:10%">
						          <col style="width:15%">
						          <col style="width:15%">
						          <col style="width:15%">
						          <col style="width:15%">
						        </colgroup>
						 		<thead>
						 			<tr>
						 				<th>과목</th>
						 				<th>학기</th>
						 				<th>개강일</th>
						 				<th>종강일</th>
						 				<th>담당교수</th>
						 			</tr>
						 		</thead>
						 		<tbody>
						 			<c:forEach var="registerList" items="${registerList}">
							 			<tr>
							 				<td>${registerList.name}</td>
							 				<td>${registerList.semester}</td>
							 				<td>${registerList.start}</td>
							 				<td>${registerList.end}</td>
							 				<td>${registerList.p_name}</td>
							 			</tr>
						 			</c:forEach>
						 	</table>
						 	</c:if>
						 	<c:if test="${empty registerList}">
										 <hr />  
										 <p class="center">신청한 강의가 없습니다.</p>
							</c:if>
				</div>				
				<div class="container_score">
				<div class="main_title">
					<img src="/Academic-Management/img/title.png" alt="성적정보"/>
					<h4>수강신청</h4>
				</div>				
				<c:if test="${!empty subjectList}">
				
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
					 		
					 		
					 		<c:forEach var="subject" items="${subjectList}" varStatus="status">
					 			<tr>
					 				<td>${fn:length(subjectList) - status.index}</td>
					 				<td>${subject.name}</td>
					 				<td>${subject.grade}</td>
					 				<td>${subject.start}</td>
					 				<td>${subject.end}</td>
					 				<td>${subject.score}</td>
					 				<td>${subject.date}</td>
					 				<td>${subject.p_name}</td>
					 				<td>${subject.room}</td>
					 				<td>${subject.people}</td>
					 				<td>${subject.regcnt}</td>
					 				<td>
					 					<input type="button" class="btn_edit btn_cancle" onclick= "goRegist(${status.index})" value="신청"/>
					 				</td>
					 			</tr>
					 			<input type="hidden" id="subno${status.index }" value="${subject.subno}" >
					 		</c:forEach>
					 		
					 		</tbody>
					 	</table>
					 	</c:if>
						<c:if test="${empty subjectList}">
							<hr />  
							<p class="center">강의가 없습니다.</p>
						</c:if>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>
