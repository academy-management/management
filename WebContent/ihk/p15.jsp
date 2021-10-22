<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수-강의정보</title>
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
		<p>강의정보</p>
	</div>
	
	<div>
		<form method="post" action="#">
			<label for = "year">연도별</label>
			<select name="year">
				<c:forEach var="year" items="${yearList}">
				<option value="${year}">${year}</option>
				</c:forEach>	
			</select>
			<select name="semester">
				<option value="1">1</option>
				<option value="2">2</option>
			</select>
			<button type="submit">조회</button>
		</form>
	</div>
	
	<table border =1>
		<thead>
			<tr>
				<th>강의코드</th>
				<th>강의명</th>
				<th>강의 기간</th>
				<th>강의 시간</th>
				<th>강의실</th>
				<th>보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="subjectList">
			<tr>
				<td><%-- ${subject.subno} --%></td>
				<td><%-- ${subject.name} --%></td>
				<td><%-- ${subject.startday} - ${subject.endday} --%></td>
				<td><%-- ${subject.subtime} --%></td>
				<td><%-- ${subject.romm} --%></td>
				<td>
					<a href="#">수강현황</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>	
	</table>
</div>
</body>
</html>