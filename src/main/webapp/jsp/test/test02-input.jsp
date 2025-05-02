<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
		<h2>체격 조건 입력</h2>
		
		<form method="get" action="/jsp/test/test02.jsp">
			<div class="d-flex align-items-end">
				<input type="text" class="form-control col-2" name="height">
				<div>cm</div>
				<input type="text" class="form-control col-2 ml-3" name="weight">
				<div>kg</div>
				<button type="submit" class="btn btn-primary ml-3">계산</button>
			</div>
		</form>
	</div>


</body>
</html>