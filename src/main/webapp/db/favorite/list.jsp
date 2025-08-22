<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.marondal.common.MysqlService" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<%
		MysqlService mysqlService = MysqlService.getInstance();
	
		mysqlService.connect();
		
		String query = "SELECT * FROM `favorite` ORDER BY `id` DESC";
		
		List<Map<String, Object>> favoriteList = mysqlService.select(query);
		
	%>

	<div class="container">
		
		<table class="table text-center">
			<thead>
				<tr>
					<th>사이트</th>
					<th>사이트 주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<% for(Map<String, Object> favorite:favoriteList) { %>
				<tr>
					<td><%= favorite.get("name") %></td>
					<td><a href="<%= favorite.get("url") %>" target="_blank"><%= favorite.get("url") %></a></td>
					<td><a href="/db/favorite/delete?id=<%= favorite.get("id") %>">삭제</a></td>
				</tr>
				<% } %>
			
			</tbody>
		</table>
		
	</div>

</body>
</html>