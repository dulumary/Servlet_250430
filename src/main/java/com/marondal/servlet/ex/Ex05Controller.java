package com.marondal.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ex05")
public class Ex05Controller extends HttpServlet {
	
	// 파라미터가 
	// 보안에 민감한 데이터가 포함되어 있는지
	// 긴 데이터가 포함되어 있는지
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		// 이름과 생년월일을 전달 받고,
		// 이름과 나이를 html로 구성
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2025 - year + 1;
		
		out.println(""
				+ "<html>\n"
				+ "		<head><title>정보</title></head>\n"
				+ "		<body>\n");
		
		out.println(""
				+ "			<h3>이름 : " + name + "</h3>\n"
				+ "			<h3>나이 : " + age + "</h3>\n");
		
		
		out.println(""
				+ "		</body>\n"
				+ "</html>");
		
		
		
		
		
	}

}
