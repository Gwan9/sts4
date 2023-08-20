<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</head>
<body>
	<h2>dept.jsp</h2>
	<div class="container">
		<table class="table">
		<tr>
		<th>부서번호</th>
		<td>${dto.deptno }</td>
		</tr>
			<tr>
				<th>부서명</th>
				<td>${dto.dname }</td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td>${dto.loc }</td>
			</tr>
			<tr>
				<td colspan="6">
				<input type="button" class="btn btn-primary" value="목록" />
				<a href="modify?deptno=${dto.deptno}"><input type="button" class="btn btn-warning" value="수정" /></a>
				<input type="button" class="btn btn-danger" value="삭제" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>