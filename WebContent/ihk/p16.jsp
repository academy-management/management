<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수-강의정보-수강현황</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div>
	<div>
		<ul style="float:right">
			<li style="float:left">
				<p>${professor.name}님 반갑습니다</p>
			</li>
			<li style="float:left">
				<select name="menu_professorInfo">
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
	</div>

	<div>
		<p>강의 수강 현황</p>
	</div>
	
	<div>
		<p>${subject.name}</p>
	</div>
	
	<table border =1>
		<thead>
			<tr>
				<th>No</th>
				<th>학번</th>
				<th>이름</th>
				<th>전공</th>
				<th>학년</th>
				<th>휴대폰</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="studentList">
			<tr>
				<td><%-- ${student.no} --%></td>
				<td><%-- ${student.sno} --%></td>
				<td><%-- ${student.name} --%></td>
				<td><%-- ${student.dname} --%></td>
				<td><%-- ${student.grade} --%></td>
				<td><%-- ${student.tel} --%></td>
				<td><%-- ${student.email} --%></td>
			</tr>
			</c:forEach>
		</tbody>	
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