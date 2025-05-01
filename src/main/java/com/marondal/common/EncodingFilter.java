package com.marondal.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 해당 필터를 거쳐갈 서블릿에 대한 url path 패턴 적용
// /servlet 로 시작하는 모든 서블릿
//@WebFilter("/servlet/*")
// 모든 서블릿
@WebFilter("/*")
public class EncodingFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 공통으로 처리할 기능 정의
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
	}

}
