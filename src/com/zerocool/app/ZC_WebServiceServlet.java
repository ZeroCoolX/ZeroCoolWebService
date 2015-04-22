package com.zerocool.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ZC_WebServiceServlet extends HttpServlet {
	
	private static final String DEFAULT_TITLE = "The Race";
	
	private ArrayList<ParticipantWebDisplay> participants = new ArrayList<ParticipantWebDisplay>();
	
	private String data;
	
	private String tableStart = "<table>"
			+ "	<tr>"
			+ "		<th>Bib Number</th>"
			+ "		<th>Name</th>"
			+ "		<th>Start Time</th>"
			+ "		<th>End Time</th>"
			+ "		<th>Elapsed Time</th>"
			+ "	</tr>";
	private String tableEnd = "</table>";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		makeTable(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		data = req.getParameter("data");
	}
	
	private void makeTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println(tableStart);
		
	}
	
}