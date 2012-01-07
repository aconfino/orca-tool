<h3>Snoop</h3>

<h4>Session Attributes</h4>
<ul>
<%
for (java.util.Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {
	String name = (String)e.nextElement();
	out.println("<li>" + name + "=" + session.getAttribute(name) + "</li>");
}
%>
</ul>