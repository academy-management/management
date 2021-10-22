<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수-홈화면</title>
</head>
<body>
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
		<!-- 최신 리스트 3-4개만 -->
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
</div>
</body>
</html>