package admin.com.oracle.amuz.control.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.amuz.control.servlet.CodeServlet;
import com.oracle.amuz.model.dao.UserDAOImp;

import admin.com.oracle.amuz.model.dao.UserDaoImp;
import admin.com.oracle.amuz.model.javabean.User;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user= new User();

	/*
	 * ajax验证码
	 */
	public String ajaxCode() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		String $code=request.getParameter("code");
		String code=session.getAttribute("code").toString();
		try {
			PrintWriter out=response.getWriter();
			if(code.equals($code)){
				out.write("success");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

				
	}
	/*
	 * 用户登陆方法
	 */
	public String login(){
		UserDaoImp dao=new UserDaoImp();
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		User $user=dao.login(user.getUsername(), user.getPassword());
		System.out.println($user);
		HttpSession session =ServletActionContext.getRequest().getSession();
		if($user!=null){
			boolean b=dao.updateLoginedHistory($user.getUserid(), $user.getLoginednum());
			System.out.println(b==true?$user.getUsername()+"已更新成功登录信息":$user.getUsername()+"更新登录信息失败");
			session.setAttribute("loginedUser",$user);
			return "LoginSuccess";
		}else{
			return "LoginFail";
		}
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
