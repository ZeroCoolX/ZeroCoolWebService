package com.zerocool.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ZC_WebServiceServlet extends HttpServlet {
	
	private static final String DEFAULT_TITLE = "The Race";
	
	private String json = "";
	
	private String tableStart = "<table id='parResultsTable'>"
			+ "<thead>"
			+ "	<tr>"
			+ "		<th>Bib Number</th>"
			+ "		<th>Event Name</th>"
			+ "		<th>Start Time</th>"
			+ "		<th>Finish Time</th>"
			+ "		<th>Elapsed Time</th>"
			+ "	</tr>"
			+ "<thead>";
	private String tableEnd = "</table>";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		makeTable(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		json = req.getParameter("data");
	}
	
	private void makeTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println(this.tableStart);
		writer.println("<tbody id='parBody'>");
		writer.println("</tbody>");
		writer.println(this.tableEnd);
		writer.println("<script>");
		writer.println("var text = '" + json + "';" );
		writer.println("var obj = JSON.parse(text);");
		writer.println("for (var k in obj) {");
		writer.println("	document.getElementById('parBody').innerHTML += '<tr> '+'<td>' +obj[k].bib+'</td> '+'<td>'+obj[k].eventName+'</td> '+'<td>' + obj[k].startTime + '</td> '+'<td>'+obj[k].finishTime+'</td> '+'<td>'+obj[k].elapsed+'</td> '+ '</tr>';");
		writer.println("}");
		writer.println("");
		writer.println("</script>");
	}
}