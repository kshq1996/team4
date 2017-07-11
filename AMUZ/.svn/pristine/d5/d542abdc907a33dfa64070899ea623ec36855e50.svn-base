package com.oracle.amuz.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.oracle.amuz.model.dao.BaseDAO;
import com.oracle.amuz.model.dao.ProductDAOImp;
import com.oracle.amuz.model.javabean.PageBean;
import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;
import com.sun.accessibility.internal.resources.accessibility;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private BaseDAO daoImp=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch (method) {
		case "searchByButton":
			searchByButton(request, response);
			break;
		case "getInfoById" :
			getInfoById(request, response);
			break;
		case "listByPage" :
			listByPage(request, response);
			break;
		case "searchByInputKey" :
			searchByInputKey(request, response);
			break;
		}
	}

	private void searchByInputKey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String key=request.getParameter("inputkey");
		key = new String (key.getBytes("iso8859-1"),"UTF-8");
		System.out.println(key);
		ProductDAOImp productDAOImp=new ProductDAOImp();
		System.out.println(key);
		int count=12;
		int firstPage=1;
		int nowPage=firstPage;
		int allCount=productDAOImp.getAllProductCount(key);
		int wagePage=(allCount%count==0)?(allCount/count):(allCount/count+1);
		int nextPage=nowPage==wagePage?wagePage:(nowPage+1);
		int previousPage=nowPage==1?1:(nowPage-1);
		List<Product> products=productDAOImp.listProductByPage(firstPage, count, key);
		
		PageBean page=new PageBean(count, nowPage, nextPage, previousPage, firstPage, wagePage, allCount);
		request.setAttribute("page", page);
		request.setAttribute("key", key);
//		PageBean page=new PageBean(count, nowPage, nextPage, previousPage, firstPage, wagePage, allCount)
		request.setAttribute("productByButtonkey", products);
		request.getRequestDispatcher("home/searchname.jsp").forward(request, response);
		
	}

	private void listByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		String count=request.getParameter("count");
		String key=request.getParameter("key");
		ProductDAOImp daoImp=new ProductDAOImp();

		List<Product>  ps=daoImp.listProductByPage(Integer.parseInt(page), Integer.parseInt(count),key);
		ps.toString();
		response.setContentType("text/json;charset=utf-8");
//		PrintWriter out=response.getWriter();
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getWriter(), ps);

	}

	private void getInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		ProductDAOImp daoImp=new ProductDAOImp();
		ProductInfo pInfo=daoImp.getProductDetailInfoById(Integer.parseInt(id));
		
		request.setAttribute("pInfo", pInfo);
		request.getRequestDispatcher("home/introduction.jsp").forward(request, response);
	}

	private void searchByButton(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonkey=request.getParameter("buttonkey");
		ProductDAOImp productDAOImp=new ProductDAOImp();
		int count=12;
		int firstPage=1;
		int nowPage=firstPage;
		int allCount=productDAOImp.getAllProductCount(buttonkey);
		int wagePage=(allCount%count==0)?(allCount/count):(allCount/count+1);
		int nextPage=nowPage==wagePage?wagePage:(nowPage+1);
		int previousPage=nowPage==1?1:(nowPage-1);
		List<Product> products=productDAOImp.listProductByPage(firstPage, count, buttonkey);
		
		PageBean page=new PageBean(count, nowPage, nextPage, previousPage, firstPage, wagePage, allCount);
		request.setAttribute("page", page);
		request.setAttribute("key", buttonkey);
//		PageBean page=new PageBean(count, nowPage, nextPage, previousPage, firstPage, wagePage, allCount)
		request.setAttribute("productByButtonkey", products);
		request.getRequestDispatcher("home/searchname.jsp").forward(request, response);
	}

}
