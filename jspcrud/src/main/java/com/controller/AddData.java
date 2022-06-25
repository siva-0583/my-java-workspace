package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.model.StudentManager;


public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try
		{
			Student S = new Student();
			StudentManager SM = new StudentManager();
			
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			double scgpa = Double.parseDouble(request.getParameter("scgpa"));
			
			S.setStudentid(sid);
			S.setName(sname);
			S.setCgpa(scgpa);
			
			String ack = SM.saveData(S);
			
			pw.print(ack);
		}
		
		catch(Exception e)
		{
			pw.print(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
