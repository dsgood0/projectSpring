<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form action="add" method="post">
	<table>
		<tr>
			<td>프로젝트 이름</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>프로젝트 내용</td>
			<td><textarea name="content" rows="10" cols="30"></textarea></td>
		</tr>
		<tr>
			<td>시작날짜</td>
			<td><input type="date" name="startdate"></td>
		</tr>
		<tr>
			<td>종료날짜</td>
			<td><input type="date" name="enddate"></td>
		</tr>
		<tr>
			<td>상태</td>
			<td><select name="state">
				<option value="1">준비</option>
				<option value="2">진행중</option>
				<option value="3">완료</option>
				<option value="4">보류</option>				
			</select></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="저장">
				<input type="reset" value="취소">
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>