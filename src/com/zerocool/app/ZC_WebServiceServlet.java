package com.zerocool.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.*;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;

@SuppressWarnings("serial")
public class ZC_WebServiceServlet extends HttpServlet {
	
	ArrayList<ParticipantView> pars = new ArrayList<ParticipantView>();
	
	private String tableStart = "<table id='parResultsTable'>"
			+ "	<tr>"
			+ "		<th>Bib Number</th>"
			+ "		<th>Event Name</th>"
			+ "		<th>Start Time</th>"
			+ "		<th>Finish Time</th>"
			+ "		<th>Elapsed Time</th>"
			+ "	</tr>";
	
	private String tableEnd = "</table>";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<link rel='stylesheet' type='text/css' href='webserv.css'>");
		makeTable(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		pars = new Gson().fromJson(req.getParameter("data"), new TypeToken<ArrayList<ParticipantView>>(){}.getType());
	}
	
	private void makeTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println(this.tableStart);
		
		Collections.sort(pars, new ParticipantView.Com());
		
		for (ParticipantView p : pars) {
			writer.println(p.toRow());
		}
		
		writer.println(this.tableEnd);
//		writer.println("<script>");
//		writer.println("var text = '" + json + "';" );
//		writer.println("var obj = JSON.parse(text);");
//		writer.println("for (var k in obj) {");
//		writer.println("	document.getElementById('parBody').innerHTML += '<tr> '+'<td>' +obj[k].bib+'</td> '+'<td>'+obj[k].eventName+'</td> '+'<td>' + obj[k].startTime + '</td> '+'<td>'+obj[k].finishTime+'</td> '+'<td>'+obj[k].elapsed+'</td> '+ '</tr>';");
//		writer.println("}");
//		writer.println("");
//		writer.println("</script>");
	}
}