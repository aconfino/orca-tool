package com.orca.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>The servlet example </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>A simple web application</h1>");
		out.println("<form method=\"POST\" action=\"superKick\">");
		out.println("<label for \"name\">Enter your name </label>");
		out.println("<input type=\"text\" id=\"name\" name=\"name\"/><br><br>");
		out.println("<input type=\"submit\" value=\"Submit Form\"/>");
		out.println("<input type=\"reset\" value=\"Reset Form\"/>");
		out.println("</form>");
		out.println("<form method=\"POST\" action=\"reverse\">");
		out.println("<label for \"reverse\">Enter something you want reversed </label>");
		out.println("<input type=\"text\" id=\"reverse\" name=\"reverse\"/><br><br>");
		out.println("<input type=\"submit\" value=\"Submit Form\"/>");
		out.println("<input type=\"reset\" value=\"Reset Form\"/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		PrintWriter out = response.getWriter();
		String string = "Welcome " + request.getParameter("name");
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>The servlet example </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>A simple web application</h1>");
		out.println("<h2>" + string + "</h2>");
		out.println("<br><br>");
		out.println("<a href=\"/superKick\">"+"Click here to go back to input page "+"</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
