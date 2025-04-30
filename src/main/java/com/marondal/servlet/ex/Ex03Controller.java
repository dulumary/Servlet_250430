package com.marondal.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ex03")
public class Ex03Controller extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 이름과 생년월일을 전달 받고, 
		// 이름과 나이를 html 로 구성
		
		// 이름과 나이 정보만 전달 
		
		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		// 이름과 생년월일을 전달 받는다. 
		// request에서 name이란 이름으로 값을 꺼내 쓸꺼니 채워라 
		// request에서 birthday이란 이름으로 값을 꺼내 쓸꺼니 20041211 형식으로  채워라
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		
		String yearString = birthday.substring(0, 4);
		int year = Integer.parseInt(yearString);
		
		int age = 2025 - year + 1;
		
		// 김인규, 31
		// 데이터를 전달하기 위한 문자열 규격 
		// JSON (Javascript Object Notation)
		// {"name":"김인규", "age":31}
		// ["김인규", "유재석", "지예은"]
		
		out.println("{\"name\":\"" + name + "\", \"age\":" + age +"}");
		
//		out.println(""
//				+ "<html>\n"
//				+ "		<head><title>정보</title></head>\n"
//				+ "		<body>\n"
//				+ "			<h3>이름 : " + name + "</h3>\n"
//				+ "			<h3>나이 : " + age + "</h3>\n"
//				+ "		</body>\n"
//				+ "</html>");
	}

}






