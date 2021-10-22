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
		<form method="get" action="/std_search" style="">
			<span>아이콘<i>학생 관리</i></span>
			<div>
				입학년도 <select class="form-select form-select-sm" style="width : 100px; display: inline;">
				  <option>2021</option>
				  <option>2020</option>
				  <option>2019</option>
				  <option>2018</option>
				  <option>2017</option>
				  <option>2016</option>
				  <option>2015</option>
				  <option>2014</option>
				</select>				
				  <span>이름</span>
				  <input type="text"name="name" placeholder="Username">								
				  <input type="submit" formaction="/std_allSearch" value="전체조회">
				  <input type="submit" formaction="/std_search" value="조회">
			</div>
		</form>	              
	  <table class="table">
	    <thead>
	      <tr>
	        <th>학번</th>
	        <th>이름 </th>
	        <th>전공</th>
	        <th>학년</th>
	        <th>재학상태</th>
	        <th>보기</th>
	      </tr>
	    </thead>
	    <tbody>
		    <%-- <c:forEach var="std" items="${studentList}"> --%>
		      <tr>
		        <td>std.sno</td>
		        <td>std.name</td>
		        <td>department.name</td>
		        <td>std.grade</td>
		        <td>std.state</td>
		        <td><a href="/std_detail?sno=${std.sno}">상세보기</a></td>
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