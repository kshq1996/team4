package com.oracle.amuz.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.amuz.model.dao.OrderDAOImp;
import com.oracle.amuz.model.dao.UserDAOImp;
import com.oracle.amuz.model.javabean.Address;
import com.oracle.amuz.model.javabean.Orders;
import com.oracle.amuz.model.javabean.ProductInfo;
import com.oracle.amuz.model.javabean.User;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	Orders orders= new Orders();
	ArrayList<Address> addresses=new ArrayList<Address>();
	ArrayList<Address> addresses_person=new ArrayList<Address>();
	HashMap<Integer, ProductInfo> productInfos=new HashMap<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "selectAddress":
			selectAddress(request, response);
			break;
		case "commitOrders":
			commitOrders(request, response);
			break;
		case "listAddress":
			listAddress(request, response);
			break;
		case "deleteAddress":
			deleteAddress(request, response);
			break;
		}
	}

	private void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("isLogined");
		int user_id=user.getUser_id();
		int key=Integer.parseInt(request.getParameter("key"));
		int address_id=this.addresses_person.get(key).getAddress_id();
		UserDAOImp daoImp=new UserDAOImp();
		boolean result=daoImp.deleteAddress(address_id, user_id);
		PrintWriter out =response.getWriter();
		if (result) {
			out.write("success");
		}else{
			out.write("error");
		}
		out.flush();
		out.close();

	}

	private void listAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = (User) request.getSession().getAttribute("isLogined");
			UserDAOImp userdao = new UserDAOImp();
			ArrayList<Address> addresses = userdao.getAddressById(user.getUser_id());
			if (addresses != null) {
				request.setAttribute("listAddress", addresses);
			} else {
				request.setAttribute("noListAddress", "无收货地址请添加");
			}
			this.addresses_person=addresses;
			request.getRequestDispatcher("person/address.jsp").forward(request, response);		
	}

	private void commitOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressid=Integer.parseInt(request.getParameter("getaddressid"));
		this.orders.setAddress_id(this.addresses.get(addressid).getAddress_id());
		OrderDAOImp orderdao = new OrderDAOImp();
		boolean bl=orderdao.update(this.orders);
		if(bl){
//			for (Integer i : this.productInfos.keySet()) {
//				this.productInfos.remove(i);
//			}
			request.setAttribute("orders", this.orders);
			request.setAttribute("address", this.addresses.get(addressid));
			HashMap<Integer, ProductInfo> productInfos = (HashMap<Integer, ProductInfo>) request.getSession()
					.getAttribute("shopcart");
			productInfos.clear();
			request.getSession().setAttribute("shopcart", productInfos);
			request.getRequestDispatcher("home/success.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("commitError", "订单提交出错了！请重新提交");
			request.getRequestDispatcher("home/shopcart.jsp").forward(request, response);
		}
	}

	private void selectAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("isLogined");
		if (user == null) {
			request.getRequestDispatcher("home/login.jsp").forward(request, response);
		} else {
			StringBuffer order_id = new StringBuffer();
			for (int i = 0; i < 15; i++) {
				int num = new Random().nextInt(10);
				order_id.append(num);
			}
			HashMap<Integer, ProductInfo> productInfos = (HashMap<Integer, ProductInfo>) request.getSession()
					.getAttribute("shopcart");
			UserDAOImp userdao = new UserDAOImp();
			ArrayList<Address> addresses = userdao.getAddressById(user.getUser_id());
			if (addresses != null) {
				request.setAttribute("Addresses", addresses);
			} else {
				request.setAttribute("NoAddress", "无收货地址请添加");
			}
			
			Orders orders = new Orders();
			Date DATE = new Date();
			long times = DATE.getTime();// 时间戳
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = formatter.format(DATE);

			orders.setDate(date);
			orders.setOrderstatus(0);
			orders.setOrder_id(new BigInteger(order_id.toString()));
			orders.setShopcarts(productInfos);
			orders.setUser_id(user.getUser_id());
			this.orders=orders;
			this.addresses=addresses;
			this.productInfos=productInfos;
			
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("home/pay.jsp").forward(request, response);
		}
	}
}
