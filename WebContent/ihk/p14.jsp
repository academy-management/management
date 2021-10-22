<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p14</title>
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
		<form action="#">
			<div>
				<label for="pno">아이디</label>
				<input type="text" name="pno" id="pno" disabled ="disabled">
				<input type="text" name="pno" id="pno" hidden ="disabled">
			</div>
			<div>
				<label for="dname">학과</label>
				<input type="text" name="dname" id="dname" disabled="disabled">
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" name="name" id="name">
			</div>
			<div>
				<label for="pwd">비밀번호</label>
				<input type="password" id="pwd" name="pswd">
			</div>
			<div class="mb-3">
				<label for="pwd">새비밀번호</label>
				<input type="password" id="pwd-new" name="pswd-new">
			</div>
			<div>
				<label for="phone">연락처</label>
				<input type="text" id="phone" name="phone">
			</div>
			<div>
				<label for="email">Email</label>
				<input type="email" id="email" name="email">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="sample4_postcode" placeholder="우편번호" name="postcode" style="width:200px">
				<input type="button" class="btn btn-primary" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
			</div>
				<div class="form-group">
				<input type="text" class="form-control" id="sample4_roadAddress" placeholder="주소" name="roadaddress">
			</div>
				<div class="form-group">
				<input type="text" class="form-control" id="sample4_extraAddress" placeholder="상세주소를 입력하세요" name="extraaddress">
			</div>
			
			<button type="button" onclick="location.href='#'">취소</button>
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
	</div>
</div>
</body>
</html>