<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h2>list</h2>
	<div class="container">
		<table class="table">
			<tr>
			<td>
			<a href="write" class="btn btn-primary">작성</a>
			<a href="../home" class="btn btn-warning">홈으로</a>
			</tr>
			
			<tr>
				<th>작성번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="dto" items="${list }">
			<tr>
			<td>${dto.bno}</td>
			<td>${dto.writer}</td>
			<td><a href="detail?bno=${dto.bno}">${dto.title}</a></td>
			<%-- <td>${dto.regdate}</td> --%>
			<td><fmt:parseDate var="dateString" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${dateString}" pattern="yyyy-MM-dd"/></td>
			<td><a href="delete?bno=${dto.bno}" class="btn btn-danger">삭제</a></td>
			<td><a href="modify?bno=${dto.bno}" class="btn btn-info">수정</a></td>
			</tr>
			</c:forEach>
			<tr>	
			<td colspan="4">
			
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  <c:if test="${map.prev }">
				    <li class="page-item"><a class="page-link" href="list?currentPage=${map.currentPage-5}">이전</a></li>
				  </c:if>
				<c:forEach var="i" begin="${map.startPageNo }" end="${map.endPageNo }">
					<li class="page-item"><a class="page-link" href="list?currentPage=${i}">${i}</a></li>
				</c:forEach>
				
					<c:if test="${map.next }">
				    <li class="page-item"><a class="page-link" href="list?currentPage=${map.currentPage+5}">다음</a></li>
					</c:if>
				  </ul>
				</nav>
			
			</td>
			</tr>
		</table>
	</div>
</body>
</html>