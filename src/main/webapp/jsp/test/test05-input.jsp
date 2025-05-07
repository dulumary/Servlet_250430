<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>길이 변환</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>길이 변환</h2>
		
		<form method="post" action="/jsp/test/test05.jsp">
			<div class="d-flex align-items-end">
				<input type="text" class="form-control col-2" name="cm">
				<div>cm</div>
			</div>
			
			<div class="mt-2">
				<label>인치 <input type="checkbox" name="unit" value="inch"></label>
				<label>야드 <input type="checkbox" name="unit" value="yard"></label>
				<label>피트 <input type="checkbox" name="unit" value="feet"></label>
				<label>미터 <input type="checkbox" name="unit" value="meter"></label>
			</div>
			
			<button type="submit" class="btn btn-success ">변환</button>
		</form>
	
	</div>

</body>
</html>