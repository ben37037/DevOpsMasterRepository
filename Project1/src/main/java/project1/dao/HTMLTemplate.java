package project1.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HTMLTemplate 
{
	public static void goBack(PrintWriter outIn)
	{
		outIn.println("<h3 style='color: green'>Hello, World!</h3>");
		
		outIn.println("<hr><input type='button' value='BACK' onclick='goBack()'>" +
                	"<script>function goBack(){window.history.back();}" + "</script>");
	}
	
	public static PrintWriter getHtmlOut(HttpServletResponse responseIn) throws IOException
	{
		responseIn.setContentType("text/html");
		return responseIn.getWriter();
	}
	
	public static void printTableHeaders(PrintWriter outIn, String ...headersIn)
	{
		outIn.println("<table border='2px'><tr>");
		for(String headers: headersIn)
		{
			outIn.println("<th>" + headers + "</th>");
		}
		outIn.println("</table>");
	}
}
