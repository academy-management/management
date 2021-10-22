<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page09</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<div>
	<ul style="float:right">
		<li style="float:left">
			<p>${student.name}님 반갑습니다</p>
		</li>
		<li style="float:left">
			<select name="menu_studentInfo">
				<option value="#"></option>
				<option value="#"></option>
				<option value="#"></option>
				<option value="#"></option>
			</select>
		</li>
		<li style="float:left">
			<a href="#">로그아웃</a>
		</li>	
	</ul>
	<div>
		공지사항
	</div>
	<div>
		<form method="post" action="#">
			<input type="radio" name ="division" value="전체"/> 전체
			<input type="radio" name ="division" value="notice.subject"/> 학과
			<input type="text" name="searchSubject"/> 
			<input type="submit" value="검색">
		</form> 
	</div>
	<table>
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach var="notice" items="${noticeList}">
		<tbody>
			<tr>
				<td>${notice.nno}</td>
				<td>${notice.subject}</td>
				<td>${notice.time}</td>
				<td>관리자</td>
				<td>${notice.view}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	<!-- 페이징 -->
	<div style = "margin:0 auto;">
		<ul class="pagination">
			<c:if test="${pageGroupResult.beforePage}">
				<li class="page-item">
					<a class="page-link" href="#"> &lt; </a>
				</li> 
			</c:if>
			
			<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
				<c:choose>
					<c:when test="">
						<li class="page-item active">
							<a class="page-link" href="#">${index}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="#">${index}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${pageGroupResult.afterPage}">
				<li class="page-item">
					<a class="page-link" href="#"> &gt; </a>
				</li> 
			</c:if>
		</ul>
	</div>
	
</div>		
	
</body>
</html>