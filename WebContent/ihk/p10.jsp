<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>공지사항</div>
<div>
	<div>
		${sutdent.name}님 반갑습니다. 
		<a href ="logout">로그아웃</a>
	</div>

	<table border =1>
		<thead>
			<tr>
				<th>작성자</th>
				<th>관리자</th>
				<th>작성일</th>
				<th>${notice.time}</th>
				<th>조회수</th>
				<th>${notice.views}</th>
			</tr>
			<tr>
				<th>제목</th>
				<th colspan = 5>홈페이지 리뉴얼 안내 드립니다.</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan = 6>
				"홈페이지 리뉴얼 안내 드립니다."
					${notice.contents}
				</td>
			</tr>
		</tbody>
	</table>
	<button type="button" onclick="location.href='#'">목록</button>
</div>
</body>
</html>