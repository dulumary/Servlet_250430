<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비만도 결과</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<%
		int weight = Integer.parseInt(request.getParameter("weight"));
		int height = Integer.parseInt(request.getParameter("height"));
		
		// BMI =  몸무게 / ((키 / 100.0) * (키 / 100.0));
		
		double bmi = weight / ((height / 100.0) * (height / 100.0));
		
		String result = null;
		if(bmi < 18.5) {  // 저체중
			result = "저체중";
		} else if(bmi < 25) {  // 정상
			result = "정상";
		} else if(bmi < 30) {  // 과체중
			result = "과체중";
		} else {  // 비만
			result = "비만";
		}
	%>

	<div class="container">
		<h2>BMI 측정결과</h2>
		<div class="display-4">당신은 <span class="text-info"><%= result %></span>입니다.</div>
		<div>BMI 수치 : <%= bmi %></div>
	</div>

</body>
</html>