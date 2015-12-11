<%@ page import="com.hanains.guestbook.dao.GuestBookDao" %>
<%@ page import="com.hanains.guestbook.vo.GuestBookVo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	GuestBookDao dao = new GuestBookDao();
	List<GuestBookVo> list = dao.getList();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/insert" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right>
				<input type="hidden" name="a" value="insert">
				<input type="submit" VALUE=" 확인 ">
			</td>
		</tr>
	</table>
	</form>
	
	<!-- 반복부분 -->
	<%
		int countTotal = list.size();
		int index = 0;
		for(GuestBookVo vo : list)	{
	%>
	<br>
	
	<form action="/guestbook3/deleteform" method="post">
	<table width=510 border=1>
		<tr>
			<td><%=countTotal-index++ %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getDate() %></td>
			
			<td><input type="submit" value="삭제"></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage() %></td>
		</tr>
	</table>
	<input type="hidden" name="a" value="delete">
	<input type='hidden' name="no" value="<%=vo.getNo() %>"> 
	<input type='hidden' name="pwd" value="<%=vo.getPassword() %>">
	</form>
		<%
		}
	%>
</body>
</html>