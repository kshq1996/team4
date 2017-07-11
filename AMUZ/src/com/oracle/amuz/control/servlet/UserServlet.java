package com.oracle.amuz.control.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.codehaus.jackson.map.ObjectMapper;

import com.oracle.amuz.model.dao.OrderDAOImp;
import com.oracle.amuz.model.dao.UserDAOImp;
import com.oracle.amuz.model.javabean.Address;
import com.oracle.amuz.model.javabean.Orders;
import com.oracle.amuz.model.javabean.ProductInfo;
import com.oracle.amuz.model.javabean.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private UserDAOImp userDAO;
	
	public void init() throws ServletException {
		userDAO=new UserDAOImp();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println("注册？");
		switch (method) {
		case "register":
			try {
				register(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "login":
			login(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		case "updateHeadImg":
			updateHeadImg(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "checkUsername":
			checkUsername(request,response);
			break;
		case "insertAddress":
			insertAddress(request,response);
			break;
		case "listAllOrders":
			listAllOrders(request,response);
			break;
			
		case "ajaxCheckCode":
			ajaxCheckCode(request,response);
			break;
		case "ajaxUpload":
			ajaxUpload(request,response);
		break;
		}
	}
	private void ajaxUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
	}

	private void ajaxCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code=request.getParameter("code");
		System.out.println("code");
		String code_sys=request.getSession().getAttribute("code").toString();
		PrintWriter out=response.getWriter();
		if(code.equals(code_sys))
			out.write("true");
		else
			out.write("false");
		out.flush();
		out.close();
		
	}

	private void listAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =((User)request.getSession().getAttribute("isLogined")).getUser_id();
		OrderDAOImp daoImp=new OrderDAOImp();
		List<Orders> listOrders=daoImp.getAllOrdersByUserid(id);
		if(listOrders!=null){
			HashMap<Long, List<ProductInfo>> hashmapproducts=daoImp.getOrdersdetailByOrdersid(listOrders);
			for (Long l : hashmapproducts.keySet()) {
				for (Orders orders : listOrders) {
					if(l==orders.getOrder_id().longValue()){
						for (ProductInfo productInfo : hashmapproducts.get(l)) {
							System.out.println(l+"\t"+productInfo.getProductName());
						}
					}
				}
			}
			request.setAttribute("hashmapproducts", hashmapproducts);
		}
		request.setAttribute("listOrders", listOrders);
		request.getRequestDispatcher("person/order.jsp").forward(request, response);
	}

	private void insertAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =((User)request.getSession().getAttribute("isLogined")).getUser_id();
		String name=request.getParameter("name");
		int phonenum=Integer.parseInt(request.getParameter("phonenum"));
		String province=request.getParameter("province");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		String addressdetail=request.getParameter("addressdetail")==null?"待填":request.getParameter("addressdetail");
		
		UserDAOImp daoImp=new UserDAOImp();
		Address address=new Address(0, city, province, state, street, addressdetail, id, phonenum, name);
		boolean result=daoImp.insertAddress(id, address);
		PrintWriter out=response.getWriter();
		response.setContentType("text/json;charset=utf-8");
		ObjectMapper mapper=new ObjectMapper();
		if(result)
			mapper.writeValue(out, address);
		else
			out.write("fail");
		out.flush();
		out.close();
	}

	private void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String username=request.getParameter("username");
		UserDAOImp daoImp=new UserDAOImp();
		boolean bl=daoImp.searchUserByUsername(username);
		PrintWriter out=response.getWriter();
		if(bl){
			System.out.println("不存在"+username);
			out.write("true");
		}else{
			System.out.println("存在"+username);
			out.write("false");
		}
		out.flush();
		out.close();
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String truename=request.getParameter("truename");
		truename = new String (truename.getBytes("iso8859-1"),"UTF-8");//
		String sex=request.getParameter("sex").equals("0")?"M":"F";
		String email=request.getParameter("email")==null?null:request.getParameter("email");
		int id =((User)request.getSession().getAttribute("isLogined")).getUser_id();
		
		System.out.println(truename+"\t"+sex+"\t"+email+"\t"+id);
		
		User user=new User();
	
		user.setEmail(email);
		user.setSex(sex);
		user.setUser_id(id);
		user.setTruename(truename);
		
		UserDAOImp daoImp=new UserDAOImp();
		boolean bl=daoImp.update(user);
		if(bl){
			User updateuser=(User) request.getSession().getAttribute("isLogined");
			updateuser.setEmail(email);
			updateuser.setSex(sex);
			updateuser.setUser_id(id);
			updateuser.setTruename(truename);
			request.getSession().setAttribute("isLogined", updateuser);
			request.setAttribute("updateSuccess", "信息已更新！");
			request.getRequestDispatcher("person/information.jsp").forward(request, response);
		}else{
			request.setAttribute("updateFail", "更新失败！");
			request.getRequestDispatcher("person/information.jsp").forward(request, response);
		}
	}

	private void updateHeadImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用了图片上传！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Part part=request.getPart("file");
		String headinfo=part.getHeader("content-disposition");
		String filename=headinfo.substring(headinfo.lastIndexOf("=")+2,headinfo.length()-1);
		String filesavingfolder=this.getServletContext().getRealPath("/UserServlet");
		String filesavingpath=filesavingfolder+File.separator+filename;
		File f=new File(filesavingfolder+File.separator);
		if(!f.exists()){
			f.mkdirs();
		}
		part.write(filesavingpath);
		out.println("上传成功！");
		System.out.println("图片上传成功，位置为:"+filesavingpath);
	} 

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("isLogined");
		request.getRequestDispatcher("/home/home.jsp").forward(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String code=request.getParameter("code");
		String code_sys=request.getSession().getAttribute("code").toString();
		if(code.equals(code_sys)){
			String u=request.getParameter("username");
			String p=request.getParameter("password");
			
			boolean isOK =userDAO.add(u, p);
			if(isOK){
				User user =userDAO.login(u, p);
				request.getSession().setAttribute("isLogined", user);
				request.getRequestDispatcher("home/home.jsp").forward(request, response);
			}else{
				System.out.println(u+"      "+p);
				request.setAttribute("failedRegister", "账号已存在！换一个试试吧");
				request.getRequestDispatcher("home/register.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("errorCode","验证码错误！" );
			request.getRequestDispatcher("/home/register.jsp").forward(request, response);
		}
		}
		private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			
			User user =userDAO.login(username, password);
			
			if(user==null){
				request.setAttribute("errorLogined", "账号密码错误！ ");
				request.getRequestDispatcher("/home/login.jsp").forward(request, response);
			}else{
				if(request.getParameterValues("isRemember")!=null){
					Cookie u=new Cookie("username", username);
					u.setDomain("www.amuz.com");
					Cookie p=new Cookie("password", password);
					p.setMaxAge(60*60*24*10);
					p.setDomain("www.amuz.com");
					
					response.addCookie(u);
					response.addCookie(p);
							
				}else{
					Cookie p=new Cookie("password", password);
					p.setMaxAge(60*60*24*10);
					p.setDomain("www.amuz.com");
					response.addCookie(p);
				}
				request.getSession().setAttribute("isLogined", user);
				request.getRequestDispatcher("/home/home.jsp").forward(request, response);
			}	
		}
}	
