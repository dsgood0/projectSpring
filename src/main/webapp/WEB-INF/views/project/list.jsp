<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table {
		border-collapse: collapse;
	}
	th, td{
		border:1px solid black;
		padding:5px;
	}	
</style>
<body>
	<a href="add">[새 프로젝트 등록]</a>

	<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/project/detail?no=${vo.no}">${vo.title}</a></td>
				<fmt:formatDate var="sdate" value="${vo.startdate}" pattern="yyyy-MM-dd"/>
				<td>${sdate}</td>
				<fmt:formatDate var="edate" value="${vo.enddate}" pattern="yyyy-MM-dd"/>
				<td>${edate}</td>
				<td>
					<c:if test="${vo.state == 1}">
						준비
					</c:if>
					<c:if test="${vo.state == 2}">
						진행중
					</c:if>
					<c:if test="${vo.state == 3}">
						완료
					</c:if>
					<c:if test="${vo.state == 4}">
						보류
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>