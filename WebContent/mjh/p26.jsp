<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
	<form method="post" action="student_search">
	<input type="text" name="name" placeholder ="이름 검색"/><input type="submit" class="btn btn-outline-dark" value="검색"/><br> 
	</form>
	
	<c:if test="${!empty studentList}"> 
	 <table class="table table-bordered table-sm">
	<tr>
	<th>학번</th>
	<th>이름</th>
	<th>입학년도</th>
	<th>전공</th>
	<th>핸드폰번호</th>
	<th>상태</th>
	<th>수정</th>
	</tr>
	
	<c:forEach var="student" items="${studentList}"> 

	<tr>
	<td>${student.sno}</td>
	<td>${student.name}</td>
	<td>${student.year}</td>
	<td>${student.d_name}</td>
	<td>${student.tel}</td>
	<td>${student.state}</td>
	<td><input type="button" value="수정"></td>

	</tr>

    </c:forEach>
    
	</table>
  	</c:if>
  	
	<c:if test="${empty studentlist}"> 
	학생이 없습니다..
	</c:if>
	
	
	</div>
	
</body>
</html>