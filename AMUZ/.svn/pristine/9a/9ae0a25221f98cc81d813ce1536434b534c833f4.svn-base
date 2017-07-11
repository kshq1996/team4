package com.oracle.amuz.control.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import com.oracle.amuz.model.dao.ProductDAOImp;
import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch (method) {
		case "addToShopCart":
			addToShopCart(request,response);
			break;

		case "delFromShopCart":
			delFromShopCart(request,response);
			break;
		default:
			break;
		}
	}

	private void delFromShopCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		HashMap<Integer, ProductInfo> shopcart=(HashMap<Integer, ProductInfo>)session.getAttribute("shopcart");	
		shopcart.remove(id);
		session.setAttribute("shopcart", shopcart);
		request.getRequestDispatcher("home/shopcart.jsp").forward(request, response);
	}

	private void addToShopCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int num=Integer.parseInt(request.getParameter("num"));
		ProductDAOImp daoImp=new ProductDAOImp();
		ProductInfo productInfo=daoImp.getProductDetailInfoById(id);
		productInfo.setNum(num);
		HttpSession session=request.getSession();
		if(session.getAttribute("shopcart")==null){
			HashMap<Integer, ProductInfo> shopcart=new HashMap<>();;
			shopcart.put(id, productInfo);
			session.setAttribute("shopcart",shopcart );
			System.out.println("购物车为空");
			System.out.println(shopcart.get(id));
			
		} else {
			System.out.println("购物车不为空");
			HashMap<Integer, ProductInfo> shopcart=(HashMap<Integer, ProductInfo>)session.getAttribute("shopcart");

			if (shopcart.containsKey(id)) {
				System.out.println("更新数量");
				
				System.out.println(num);
				num=shopcart.get(id).getNum()+num;
				shopcart.get(id).setNum(num);
				shopcart.put(id, shopcart.get(id));
				
				session.setAttribute("shopcart",shopcart );
				
				System.out.println(shopcart.get(id));

			} else {
				System.out.println("添加了进购物车");
				shopcart.put(id, productInfo);
				System.out.println(shopcart.get(id));
				session.setAttribute("shopcart",shopcart );
			}
		}
		request.getRequestDispatcher("home/shopcart.jsp").forward(request, response);
	}
}
