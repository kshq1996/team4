package com.oracle.amuz.control.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class codeServlet
 */
@WebServlet(urlPatterns="/CodeServlet")
public class CodeServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");//设置相应的内容类型
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        
        System.out.println("进入了servlet");
        
        BufferedImage im=new BufferedImage(100, 40, Image.SCALE_DEFAULT);
        
        Graphics g= im.getGraphics();

        g.fillRect(0, 0, 100, 40);
        
       g.setColor(Color.WHITE);
        int x=5;
       
        StringBuffer  code=new StringBuffer();
        for(int n=0;n<10;n++)
        {
        	g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        	
        	g.fillRect(new Random().nextInt(100), new Random().nextInt(40), new Random().nextInt(10),new Random().nextInt(10));
        	g.drawLine(new Random().nextInt(100), new Random().nextInt(40), new Random().nextInt(100), new Random().nextInt(40));
        }
        for(int n=0;n<6;n++)
        {
        	int randomTextSize=new Random().nextInt(25)+15;
        	if(new Random().nextInt(2)==1)
        	{
        		g.setFont(new Font("宋体", Font.BOLD, randomTextSize));
        	}else 
        	{
        		if(new Random().nextInt(2)==2)
            	{
            		g.setFont(new Font("黑体", Font.ITALIC, randomTextSize));
            	}else
            	{
            		g.setFont(new Font("楷体", Font.PLAIN, randomTextSize));
            	}
        	}
        	int randomNum=new Random().nextInt(10);
        	code.append(randomNum);
        	request.getSession().setAttribute("code", code);//将生成的验证码存储到session中，方便登陆的servlet访问这个系统生成的验证码
        	g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        	
        	g.drawString(randomNum+"", x, 30);
        	x+=randomTextSize/2;
        }
        
        System.out.println("生成的验证码是:"+code);
        ImageIO.write(im, "jpg", response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
        
	}

}
