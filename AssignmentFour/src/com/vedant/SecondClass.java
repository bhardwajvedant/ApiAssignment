package com.vedant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/secondServlet")
public class SecondClass extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw=res.getWriter();
		PojoClass pc=new PojoClass();
		Gson g=new Gson();
		
		String string=(String) req.getAttribute("stringJson");
		pc=g.fromJson(string, PojoClass.class);
		int addition=pc.getNumberOne()+pc.getNumberTwo();
		int subtraction=pc.getNumberOne()-pc.getNumberTwo();
		
		 AdditionSubtraction asc=new AdditionSubtraction(addition,subtraction);
	         String addsub=g.toJson(asc);
	     
	     req.setAttribute("addsub", addsub);
		pw.close();
	}
}
