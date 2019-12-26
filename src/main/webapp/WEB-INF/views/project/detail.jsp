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
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${vo.title}</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${vo.content}</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<fmt:formatDate var="sdate" value="${vo.startdate}" pattern="yyyy-MM-dd"/>
			<td>${sdate}</td>
		</tr>
		<tr>
			<th>종료날짜</th>
			<fmt:formatDate var="edate" value="${vo.enddate}" pattern="yyyy-MM-dd"/>
			<td>${edate}</td>
		</tr>
		<tr>
			<th>상태</th>
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
	</table>
	
	<a href="${pageContext.request.contextPath}/project/modify?no=${vo.no}">[수정]</a>
	<a href="${pageContext.request.contextPath}/project/remove?no=${vo.no}">[삭제]</a>
	<a href="${pageContext.request.contextPath}/project/list">[돌아가기]</a>
</body>
</html>