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
	  <form action="/action_page.php">
	    <div>
	      <input type="radio" id="radio1" name="optradio2" value="option1" checked>
	      <label for="radio1">전체</label>
	      <input type="radio"id="radio2" name="optradio2" value="option2">
	      <label for="radio2">학과</label>
	      <input type="text" name="search_notice" placeholder="내용을 입력해주세요">
	      <button type="submit">검색</button>
	    </div>   
	  </form>
	  <table class="table">
		    <thead>
		      <tr>
		        <th>No</th>
		        <th>제목 </th>
		        <th>작성일</th>
		        <th>조회수</th>
		      </tr>
		    </thead>
		    <tbody>
			    <%-- <c:forEach var="register" items="${noticeList}"> --%>
			      <tr>
			        <td>notice.nno</td>
			        <td>notice.title</td>
			        <td>notice.writedate</td>
			        <td>register.views</td>
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