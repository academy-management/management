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
		<span>아이콘<i>공지사항</i></span>
	  <table class="table table-striped">
	    	<tr>
	    		<td>작성일</td>
	    		<td>notice.writedate</td>
	    		<td>조회수</td>
	    		<td>notice.views</td>
	    	</tr>
	    	<tr>
	    		<td>제목</td>
	    		<td>notice.title</td>
	    	</tr>
	    	<tr>
	    		<td>notice.content</td>
	    	</tr>
	  </table>	  
	  <button type="button" class="btn btn-primary btn-lg" onclick="location.href='notice.jsp' ">뒤로</button>
	</div>
</body>
</html>