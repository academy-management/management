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
	  <table class="table table-striped">
	    	<tr>
	    		<td>학번</td>
	    		<td>student.sno</td>
	    		<td>성명</td>
	    		<td>student.name</td>
	    	</tr>
	    	<tr>
	    		<td>연락처</td>
	    		<td>student.tell</td>
	    	</tr>
	  </table>
	  <table class="table table-striped">
	    	<tr>
	    		<td>학과</td>
	    		<td>department.dno</td>
	    		<td>대학명</td>
	    		<td>student.collegename</td>
	    	</tr>
	    	<tr>
	    		<td>학년</td>
	    		<td>student.grade</td>
	    		<td>담당교수</td>
	    		<td>professor.name</td>
	    	</tr>
	    	<tr>
	    		<td>재학상태</td>
	    		<td>student.state</td>
	    		<td>주소</td>
	    		<td>student.address</td>
	    	</tr>
	    	<tr>
	    		<td>E-mail</td>
	    		<td>student.email</td>	    		
	    	</tr>
	  </table>
	  <button type="button" class="btn btn-primary btn-lg" onclick="location.href='std_list.jsp' ">뒤로</button>
	</div>
		
</body>
</html>