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
	<form method="post" action="bbs_save">
		학번<input type="text" name="sno"><br/>
		비밀번호<input type="text" name="password"><br/>
		이름<input type="text" name="name"><br/>
		소속학과<input type="text" name="d_name"><br/>
		입학년도<input type="text" name="year"><br/>
		핸드폰번호<input type="text" name="tel"><br/>
		이메일<input type="text" name="email"><br/>
		
		<input type="reset" value="원래대로" class="btn btn-outline-dark"/>
		<input type="submit" value="등록" class="btn btn-outline-dark"/> 
		
	</form>

	
	</div>
</body>
</html>