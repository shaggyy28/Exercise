<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sagar.todo.dao.ToDo"%>
<%@page import="java.util.List" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ToDo list</h1>
	
	<% String username = (String)request.getSession().getAttribute("username"); 
		if(username == null){
	%>
			<a href="login">login</a>
	<%}else{%>
			<a href="login">Welcome <%=username%></a>	
	<%
		}	
	%>
	
	<a href="linkedin">linkedin</a>
	<form action="add" method="get">
		<label>Event: </label><input name="event"></input> <label>Status:
		</label><input name="status"></input> <br>
		<br>
		<button name="action" type="submit" value="add">Add</button>
		<button name="action" type="reset" value="clear" onmouseover="echo">Clear</button>
	</form>
	<br>
	<br>

	<h3>Existing todos</h3>
	<table border="2">
		<tr>
			<td>Event</td>
			<td>Status</td>
		</tr>
		<%
			List<ToDo> todoList = (ArrayList<ToDo>) request.getAttribute("todos");
			Iterator<ToDo> iterator = todoList.iterator();
			while (iterator.hasNext()) {
				ToDo todo = iterator.next();
		%>
		<tr>
			<td><%=todo.getEvent()%></td>
			<td><%=todo.getStatus()%></td>
		</tr>
		<%
			}
			
		%>
	</table>
	
</body>
</html>