package com.vedant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Print")
public class PrintHeaAngPara extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		if(req.getMethod().equals("POST"))
		{
			res.sendError(440,"only get requests are allowed");
			
		}
		else
		{
//printing parameters
			PrintWriter out =res.getWriter();
			res.setContentType("text/html; charset=utf-8");
			
			out.write("<h1>");
			out.print("Parameters are = ");
			out.write("</h1>");
			
			
			Map<String ,String[]> m=new LinkedHashMap<>();
			m=req.getParameterMap();
			
			Set set=m.keySet();
			
			Iterator<String> itr=set.iterator();
		
			while(itr.hasNext())
			{
				String key=itr.next();
		       out.print(key+" : ");
				String[] value=m.get(key);
				for(String s:value)
				{
					out.print(s+" ");
				}
				out.println();
			}
			
//printing headers
			out.print("<h1>");
			out.print("Headers are = ");
			out.print("</h1>");
			
			Enumeration<String> enu=req.getHeaderNames();
			
			while(enu.hasMoreElements())
			{
				String headername=enu.nextElement();
			    
				out.print(headername+" : ");
				
				Enumeration<String> headers = req.getHeaders(headername);
	           
				while (headers.hasMoreElements()) {
	            	String headerValue = headers.nextElement();
	                out.println("t" + headerValue);
			}
		}
			out.close();
	 }
		
	}
}
