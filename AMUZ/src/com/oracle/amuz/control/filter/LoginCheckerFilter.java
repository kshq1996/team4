package com.oracle.amuz.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckerFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		String paramters=request.getQueryString();
		String uri=request.getRequestURI();
		if(uri.contains("person")){
			if(request.getSession().getAttribute("isLogined")==null){
				request.getRequestDispatcher("../home/login.jsp").forward(request, response);
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else if(uri.contains("OrdersServlet")){
			if(request.getSession().getAttribute("isLogined")==null){
				request.getRequestDispatcher("home/login.jsp").forward(request, response);
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else if(uri.contains("UserServlet")){
			if(paramters.contains("login")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("update")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("register")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("checkUsername")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("insertAddress")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("listAllOrders")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("ajaxCheck")){
				chain.doFilter(arg0, arg1);
			}else{
				request.getRequestDispatcher("home/login.jsp").forward(request, response);
			}
		}else if(uri.contains("ProductServlet")){
			if(paramters.contains("buttonkey")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("id")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("key")&&paramters.contains("page")&&paramters.contains("count")){
				chain.doFilter(arg0, arg1);
			}else if(paramters.contains("searchByInputKey")){
				chain.doFilter(arg0, arg1);
			}else{
				System.out.println(paramters);
				request.getRequestDispatcher("home/login.jsp").forward(request, response);
			}
		}else if(uri.contains("PayServlet")){
			if(request.getSession().getAttribute("isLogined")==null){
				request.getRequestDispatcher("home/login.jsp").forward(request, response);
			}else if(request.getSession().getAttribute("shopcart")==null){
				if(paramters.contains("listAddress")|paramters.contains("key")){
					chain.doFilter(arg0, arg1);
				}else{
				request.getRequestDispatcher("home/home.jsp").forward(request, response);
				}
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else if(uri.contains("EmailServlet")){
			if(request.getSession().getAttribute("isLogined")==null){
				request.getRequestDispatcher("home/login.jsp").forward(request, response);
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else{
			chain.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
