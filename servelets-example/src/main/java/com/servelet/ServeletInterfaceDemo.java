package com.servelet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Date;
public class ServeletInterfaceDemo implements Servlet
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		  
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		
		Date d = new Date();
		
		PrintWriter pw = res.getWriter();
		pw.print("<html>");
		pw.print("<head><title>Servlet Interface Demo</title></head>");
		pw.print("<body>");
		pw.print("<h2> Servlet created using Servelet Interface @"+d.toString()+"</h2>");
		pw.print("</body>");
		pw.print("</html>");
		
	}

}
