package com.oracle.amuz.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.amuz.model.dao.EmailCodeDAOImp;
import com.oracle.amuz.model.javabean.Email;
import com.oracle.amuz.model.javabean.User;
import com.sun.org.apache.bcel.internal.generic.DALOAD;

@WebServlet("/EmailCodeServlet")
public class EmailCodeServlet extends HttpServlet {
	static private HashMap<Integer,String> emailcode=new HashMap<>();
	static private String address;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch(method){
		case "sendEmail":
			sendEmail(request,response);
			 break;
		case "saveEmail":
			saveEmail(request,response);
			 break;
			 
		}
	}
	
	private void saveEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=((User)request.getSession().getAttribute("isLogined")).getUser_id();
		String code=request.getParameter("code");
		PrintWriter out=response.getWriter();
		for (Integer i : emailcode.keySet()) {
			if(emailcode.get(id).equals(code)){
				EmailCodeDAOImp daoimp=new EmailCodeDAOImp();
				boolean result=daoimp.changeEmailStatus(id,this.address );
				if(result){
					out.write("success");
					User user=((User)request.getSession().getAttribute("isLogined"));
					user.setEmail(this.address);
					request.getSession().setAttribute("isLogined", user);
				}else{
					out.write("fail");
				}
			}else{
				out.write("error");
			}
			out.flush();
			out.close();
		}
	}
	private void sendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=((User)request.getSession().getAttribute("isLogined")).getUser_id();
		StringBuffer code=new StringBuffer();
		for (int i = 0; i < 6; i++) {
			code.append(new Random().nextInt(10));
		}
		String receieveEmailAccount=request.getParameter("emailAddress");
		this.address=receieveEmailAccount;
		try {
			sendEmail(code, receieveEmailAccount);
			PrintWriter out=response.getWriter();
			out.write("true");
			out.flush();
			emailcode.remove(id);
			emailcode.put(id, code.toString());
			System.out.println("id:"+id+"\t"+"验证码为:"+code.toString());
			out.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
	}
	protected void sendEmail(StringBuffer code,String receieveEmailAccount) throws AddressException, UnsupportedEncodingException, MessagingException{
		Email email=new Email();
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议(javamail的规范要求)
		props.setProperty("mail.host", email.getMyemailsmtphost()); // 发件人的邮箱SMTP地址
		props.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关
		props.put("mail.smtp.port", "25");

		Session session = Session.getDefaultInstance(props,null);// 根据参数创建会话对象,用于和邮件服务器交互
		session.setDebug(true);// 监控

		MimeMessage message = createMimeMessage(code,session, email.getMyemailaccount(), email.getMyemailpassword(),receieveEmailAccount);// 创建一个邮件对象
		Transport transport = session.getTransport("smtp");//根据session获取邮件传输对象
		
		//使用邮箱账号 和 密码 连接邮件服务器
		//使用认证的邮箱必须与message中的发件人邮箱一致，否则报错
		transport.connect(email.getMyemailaccount(), email.getMyemailpassword());
		//发送邮件，发到所有的收件人地址
		transport.sendMessage(message, message.getAllRecipients());
		//关闭连接
		transport.close();

	}
	/**
	 * 
	 * @param session	传入会话对象
	 * @param myEmailAccount 传入软件邮箱名
	 * @param myEmailPassword		传入对应的SMTP授权码
	 * @param receieveEmailAccount	传入用户的邮箱
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	private  MimeMessage createMimeMessage(StringBuffer code, Session session, String myEmailAccount, String myEmailPassword,String receieveEmailAccount) throws AddressException, MessagingException, UnsupportedEncodingException {
		//创建验证码code并发送
		
		// 创建一封邮件
		MimeMessage message = new MimeMessage(session);
		// From 发件人
		message.setFrom(new InternetAddress(myEmailAccount, "Amuz"));
		// To 收件人
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receieveEmailAccount));
		// subject 主题
		message.setSubject("【Amuz】请验收您的验证码","UTF-8");
		// content 正文
		String content1 = "<html><table style='width: 538px; background-color: #393836;' align='center' cellspacing='0' cellpadding='0'>"+"\n"
				+"<tr>"+"\n"
					+"<td style='height: 65px; background-color: #000000; border-bottom: 1px solid #4d4b48;'>"+"\n"
						+"<img src='http://r.photo.store.qq.com/psb?/V114TqMo1UAnkY/lA2OSWOfbc4eWQvz47GRaY*XqTJeo4QjvhhQTgmPVgA!/r/dB8BAAAAAAAA' width='538' height='65'/>"+"\n"
					+"</td>"+"\n"
				+"</tr>"+"\n";
		String content2=
		"<tr>"+"\n"
		+"<td bgcolor='#17212e'>"+"\n"
			+"<table width='470' border='0' align='center' cellpadding='0' cellspacing='0' style='padding-left: 5px; padding-right: 5px; padding-bottom: 10px;'>"+"\n"
				+"<tr bgcolor='#17212e'>"+"\n"
					+"<td style='padding-top: 32px;'>"+"\n"
						+"<div style='padding: 20px;'>"+"\n"
						+"<span style='font-size: 24px; color: #80b3ff; font-family: Arial, Helvetica, sans-serif; font-weight: bold;'>"+"\n"
							+"你好，亲爱的用户"+"</span><br  />"+"</div>"+"</td>"+"</tr>"+"\n"
			+"<tr>"+"\n"           
			+"<td style='font-size: 15px; color: #bfb7b0; padding-top: 0px;'>"+"\n"
				+"<div style='padding: 32px;'>"+"\n"
						+"您刚刚在Amuz商城使用了本邮箱验证账号，	"
				+"</div>"+"</td>"+"</tr>"+"\n"
			+"<td style='padding: 32px 8px; padding-top: 0px;'>"+"\n"
					+"<div style='padding: 16px; background-color: rgba( 0, 0, 0, 0.2 );'>"+"\n"
						+"<span style='font-size: 18px; color: #c6d4df; font-family: Arial, Helvetica, sans-serif;'>请在指定窗口输入以下验证码：</span>"+"\n"
						+"<br  />"+"\n"
						+"<span style='font-size: 24px; color: #66c0f4; font-family: Arial, Helvetica, sans-serif; font-weight: bold;'>"+code+"</span>"+"\n"
					+"</div>"+"</td>"+"</tr>"+"\n"

			+"<tr>"+"\n"
				+"<td style='font-size: 14px; color: #c2c2c2; padding-bottom: 32px;'>"+"\n"
					+"-----------------------------------------------------------------------------------<br />"+"\n"
					+"<div style='padding: 20px;'>"+"\n"
					+"1、为了保障您帐号的安全性，请在24小时内完成验证，超过24小时请重新注册。<br />"+"\n"
					+"2、该验证码将在您完成验证后立刻失效。<br />"
					+"</div>"
					+"------------------------------------------------------------------------------------<br />"+"\n"
					+"</td>"+"\n"
			+"</tr>"+"\n"
					
			+"<tr>"+"\n"
				+"<td style='font-size: 14px; color: #c2c2c2; padding-bottom: 32px;text-align:right'>"+"\n"
				+"<div style='padding: 20px;'>"+"\n"
				+"Amuz商城运营团队祝您身体健康，工作顺利<br />"+"\n"
				+DateFormat.getDateInstance(DateFormat.FULL).format(new Date())
				+"</div>"
				+"</td>"+"\n"
			+"</tr>"+"\n"
				+"<td style='font-size: 14px; color: #6d7880; padding-top: 16px; padding-bottom: 60px;'>"+"\n"
					+"<div style='padding: 20px;'>"+"\n"
					+"如果您沒有进行任何操作，那可能有人填错了邮件地址，请忽视此邮件<br  />"
					+"<a style='color: #8f98a0;' href='https://baid.com/'>"+"https://www.didisend.com/<br /></a><br  />"+"\n"
					+"<br />"
					+"Copyright ©2017-2017 didisend.com 最终解释权归Amuz公司所有<br />"
					+"互联网违法和不良信息举报电话：xxxxxxxxx  xxxx@amuz.com"
					+"</div>"
			+"</td>"+"</tr>"+"\n"
		+"</table>"+"\n"
		+"</td>"+"</tr>"+"\n"
		+"</html>";
		//创建文本“节点”
		MimeBodyPart text = new MimeBodyPart();
		text.setContent(content1+content2,"text/html;charset=UTF-8");

		//“文本”+“图片”设置文本和图片的关系---即 融合文本和图片
		MimeMultipart mm_text_image= new MimeMultipart();
		mm_text_image.addBodyPart(text);
//		mm_text_image.addBodyPart(image);
		mm_text_image.setSubType("related");// --------related 关联关系
		//将文本和图片融合的“节点”封装成一个普通节点
		// 最终添加到邮件里的content是由多个bodypart组成的multipart
		//	我们需要的是multipart上的mm_text_image并非bodypart，要把mm_text_image封装成一个BodyPart
		MimeBodyPart text_image =new MimeBodyPart();
		text_image.setContent(mm_text_image);
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text_image);
		
		//	设置整个邮件的关系
		message.setContent(mm);
		// 设置发送时间
		message.setSentDate(new Date());
		// 保存设置
		message.saveChanges();
		return message;
	}
}
