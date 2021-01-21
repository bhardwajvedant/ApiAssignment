package com.vedant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@WebServlet("/json")
public class jsonClass extends HttpServlet {

	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
	   
		PojoClass pc=new PojoClass(Integer.parseInt(req.getParameter("num1")),Integer.parseInt(req.getParameter("num2")));
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		String stringJson=gson.toJson(pc);
       
				 req.setAttribute("stringJson", stringJson);
		         RequestDispatcher rd=req.getRequestDispatcher("secondServlet");
		         rd.include(req, res);
	     //
		         AdditionSubtraction as=new AdditionSubtraction();
		         String str=(String)req.getAttribute("addsub");
		         
		         as=gson.fromJson(str, AdditionSubtraction.class);
		         
		         int add=as.getAddition();
		         int sub=as.getSubtraction();
		         
		         int multiplyadd=add*add;
		         int multuplysub=sub*sub;
		         int multiplyaddsub=add*sub;
		         
		         LastClassParser lcp=new LastClassParser(multiplyadd,multuplysub,multiplyaddsub);
		         String lastJson=gson.toJson(lcp);
		         pw.write(lastJson);
		         
		         
		         
		        
		         
		         
		         
		         
		         
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.sendError(400,"Only post requests are allowed");
	}
	
}
