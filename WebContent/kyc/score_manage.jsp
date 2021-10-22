<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<span>아이콘<i>학생 관리</i></span>
	<div class="container mt-3">
			<div>
				과목 <select class="form-select form-select-sm" style="width : 500px; display: inline;">
				  <c:forEach var="subject" items="subjectList">
				  	<option>[subject.sno]컴퓨터와이해[subject.startdate-subject.enddate]</option>
				  </c:forEach>				  
				</select>
			</div>
		<table class="table">
		    <thead>
		      <tr>
		        <th>No</th>
		        <th>학번 </th>
		        <th>이름</th>
		        <th>전공</th>
		        <th>학년</th>
		        <th>성적입력</th>
		      </tr>
		    </thead>
		    <tbody>
			    <%-- <c:forEach var="register" items="${registerList}"> --%>
			      <tr>
			        <td>register.rno</td>
			        <td>register.sno</td>
			        <td>register.sname</td>
			        <td>register.dname</td>
			        <td>register.grade</td>
			        <td>
			        	<select class="form-select form-select-sm" style="width : 100px; display: inline;">
			        	<!-- DB에서 점수 받아와서 선택하기 -->
			        		<option>A+</option>
			        		<option>A</option>
			        		<option>A-</option>
			        		<option>B+</option>
			        		<option>B</option>
			        		<option>B-</option>
			        		<option>C+</option>
			        		<option>C</option>
			        		<option>C-</option>
			        		<option>F</option>
			        	</select>
			        	register.score<button>저장</button>
			       </td>
			      </tr>	      
		      <%-- </c:forEach> --%>
		    </tbody>
		</table>
		<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
		</ul>
	</div>
</body>
</html>