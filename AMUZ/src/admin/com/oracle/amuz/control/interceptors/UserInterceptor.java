package admin.com.oracle.amuz.control.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation Invocation) throws Exception {
		
		System.out.println("调用了拦截器");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String url=request.getRequestURI().toString();
		System.out.println(url);
		if(url.equals("/AMUZ/admin/admin-add.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-list.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-add-list.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-permission.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-permission-show.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-permission-add.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-permission-search.jsp")){
			return Invocation.invoke();
		}else if(url.equals("/AMUZ/admin/admin-permission-search")){
			return Invocation.invoke();
		}
		else{
		String actionname=url.substring(url.lastIndexOf("/")+1,url.indexOf("_"));
		String methodname=url.substring(url.lastIndexOf("_")+1);
		System.out.println(url);
		System.out.println(actionname);
		System.out.println(methodname);
		if(actionname.equals("UserAction")&&methodname.equalsIgnoreCase("login")){
			return Invocation.invoke();
		}else if(actionname.equals("UserAction")&&methodname.equalsIgnoreCase("ajaxCode")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("addAdmin")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("showActors")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("changeAdminStatus")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("deleteUser")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("deleteSelect")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("showAuthorityWithUser")){
			return Invocation.invoke();
		}else if(actionname.equals("HelpAction")&&methodname.equalsIgnoreCase("addToSession")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("removeAuthorityWithUser")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("removeAuthorityWithUserSelect")){
			return Invocation.invoke();
		}else if(actionname.equals("HelpAction")&&methodname.equalsIgnoreCase("searchUsernames")){
			return Invocation.invoke();
		}else if(actionname.equals("HelpAction")&&methodname.equalsIgnoreCase("showAuthorityToAdd")){
			return Invocation.invoke();
		}else if(actionname.equals("HelpAction")&&methodname.equalsIgnoreCase("addSelectUserToRequest")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("addOrDeleteAuthority")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("addUserToSelectAuthority")){
			return Invocation.invoke();
		}else if(actionname.equals("AdminAction")&&methodname.equalsIgnoreCase("searchAuthortiyByUsername")){
			System.out.println("pass");
			return Invocation.invoke();
		}else{
			return null;
		}
		}
	}
}
