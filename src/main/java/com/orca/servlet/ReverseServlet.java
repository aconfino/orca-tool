package com.orca.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReverseServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		PrintWriter out = response.getWriter();
		String string = reverseString(request.getParameter("reverse"));
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>The servlet example </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Your stuff is now in reverse</h1>");
		out.println("<h2>" + string + "</h2>");
		out.println("<br><br>");
		out.println("<a href=\"/superKick\">"+"Click here to go back to input page "+"</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	public String reverseString(String string){
		String reversedString = "";
		char [] charArray = string.toCharArray();
			for (int i = charArray.length-1; i > -1; i--){
				reversedString = reversedString + charArray[i];
			}
		return reversedString;
	}

}
