package com.vedant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

@WebServlet("/readingfile")
public class ReadingFIle extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
			File f=new File("C:\\Users\\Dell\\eclipse-workspace\\Eclipse programs\\AssignmentThreee\\CSVFILE.csv");
			res.setContentType("text/csv");
		    res.setHeader("Content-Disposition", "attachment; filename=\"CSVFILE.csv\"");
		    OutputStream outputStream =res.getOutputStream();
		  
		   
		    BufferedReader fr=new BufferedReader(new FileReader(f));
		    try
		    {
		      
		      String s1=fr.readLine();
		       String s="";
		       while(s1!=null)
		       {
		    	   s+=s1;
		    	   s1=fr.readLine();
		       }
		        outputStream.write(s.getBytes());
		        outputStream.flush();
		        
		        
		    }
		    catch(Exception e)
		    {
		        System.out.println(e.toString());
		    }
		    finally
		    {
		    	outputStream.close();
		        fr.close();
		    }
		}
	}

