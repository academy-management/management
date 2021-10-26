<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="../css/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/slick.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="logo">
				<h1>
					<a href="#">
						<img src="../img/logo.png" alt="ë©ì¸"/>
					</a>
				</h1>
			</div>
			<div class="user">
				<ul>
					<li>
						<p>${professor.name}ë ë°ê°ìµëë¤  <i class="xi-angle-down-min xi-x"></i></p>
						<div class="user_choice">
							<ul>
								<li><a href="">ê°ìì ë³´</a></li>
								<li><a href="">íìì ë³´ ë³ê²½</a></li>
							</ul>
						</div>
					</li>
					<li class="last">
						<a href="login_out" class="login_out">ë¡ê·¸ìì</a>
					</li>
				</ul>
			</div>
		</header>
		<div class="containers">
			<section class="container_left">
				<nav>
					<ul>
						<li><a href="">ìê°ì ì²­</a></li>
						<li><a href="">êµìì ë³´</a></li>
						<li><a href="">ê³µì§ì¬í­</a></li>
					</ul>
				</nav>
			</section>
			<section class="container_right cotainer_col">
				<div class="main_title">
					<img src="./img/title_img.png" alt="ì±ì ì ë³´"/>
					<h4>ì±ì ì ë³´</h4>
				</div>
				<div class="search_box">
					<div class="search">
						<label>ì°ë/íê¸°</label>
						<select class="search_select">
							<c:forEach var="year" items="${yearList}">
							<option value="year">${year}</option>
							</c:forEach>
						</select>
						<select class="search_select">
							<option value="1">1íê¸°</option>
							<option value="2">2íê¸°</option>
						</select>
					</div>
					<div>
						<input type="submit" class="btn_edit" value="ìì "/>
					</div>
				</div>
				<div class="container_score">
					<table class="table table-hover">
					 		<colgroup>
					          <col style="width:10%">
					          <col style="width:20%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					          <col style="width:15%">
					        </colgroup>
					 		<thead>
					 			<tr>
									<th>ê°ìì½ë</th>
									<th>ê°ìëª</th>
									<th>ê°ì ê¸°ê°</th>
									<th>ê°ì ìê°</th>
									<th>ê°ìì¤</th>
									<th>ë³´ê¸°</th>
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
										<a href="#">ìê°íí©</a>
									</td>
					 			</tr>
					 			</c:forEach>
					 		</tbody>
					 	</table>
				</div>
			</section>
		</div>
	</div>
	
</body>
</html>