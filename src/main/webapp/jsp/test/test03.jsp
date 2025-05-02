<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜 시간</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		
		<% 		
			Date now = new Date();
		
			SimpleDateFormat dateFormatter = new SimpleDateFormat("오늘 날짜 yyyy년 M월 d일");
			
			SimpleDateFormat timeFormatter = new SimpleDateFormat("현재시간 HH시 mm분 ss초");
			
			String dateString = dateFormatter.format(now);
			String timeString = timeFormatter.format(now);
			
			// 날짜와 시간중 어떤 정보를 확인하고 싶은지 전달 받는다.
			// what
			// time : 시간, date : 날짜
			
			String what = request.getParameter("what");
			
			String result = null;
			if(what.equals("time")) {
				result = timeString;
			} else {
				result = dateString;
			}
			
		%>
		
		<div class="display-4"><%= result %></div>
		
	
	</div>

</body>
</html>