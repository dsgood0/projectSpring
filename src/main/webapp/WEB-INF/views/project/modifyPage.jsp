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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("form").submit(function() {
			var title = $("input[name='title']").val();
			var content = $("input[name='content']").val();
			var sdate = $("input[name='startdate']").val();
			var edate = $("input[name='enddate']").val();
			
			if(title == "" || content == "" || sdate == "" || edate == "") {
				alert("빈칸 없이 입력해주세요.");
				return false;
			}
			
			var s = new Date(sdate);
			var e = new Date(edate);
			
			if(s.getTime() > e.getTime()){
				alert("종료날짜보다 시작날짜가 늦습니다. 다시 입력해주세요.");
				return false;
			}
		})
	});
</script>
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
	<form action="modifyPage" method="post">
	<table>
		<tr>
			<td>프로젝트 이름</td>
			<td><input type="text" name="title" value="${vo.title}">
				<input type="hidden" name="no" value="${vo.no}">
				<input type="hidden" name="page" value="${cri.page}">
			</td>			
		</tr>
		<tr>
			<td>프로젝트 내용</td>
			<td><textarea name="content" rows="10" cols="30">${vo.content}</textarea></td>
		</tr>
		<tr>
			<td>시작날짜</td>
			<fmt:formatDate var="sdate" value="${vo.startdate}" pattern="yyyy-MM-dd"/>
			<td><input type="date" name="startdate" value="${sdate}"></td>
		</tr>
		<tr>
			<td>종료날짜</td>
			<fmt:formatDate var="edate" value="${vo.enddate}" pattern="yyyy-MM-dd"/>
			<td><input type="date" name="enddate" value="${edate}"></td>
		</tr>
		<tr>
			<td>상태</td>
			<td><select name="state">
				<c:if test="${vo.state == 1}">
					<option value="1" selected>준비</option>
					<option value="2">진행중</option>
					<option value="3">완료</option>
					<option value="4">보류</option>
				</c:if>
				<c:if test="${vo.state == 2}">
					<option value="1">준비</option>
					<option value="2" selected>진행중</option>
					<option value="3">완료</option>
					<option value="4">보류</option>
				</c:if>
				<c:if test="${vo.state == 3}">
					<option value="1">준비</option>
					<option value="2">진행중</option>
					<option value="3" selected>완료</option>
					<option value="4">보류</option>
				</c:if>
				<c:if test="${vo.state == 4}">
					<option value="1">준비</option>
					<option value="2">진행중</option>
					<option value="3">완료</option>
					<option value="4" selected>보류</option>
				</c:if>	
			</select></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>