package com.zerocool.app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ZC_WebServiceServlet extends HttpServlet {
	
	private static final String DEFAULT_TITLE = "The Race";
	
	private ArrayList<ParticipantWebDisplay> participants = new ArrayList<ParticipantWebDisplay>();
	private int version = 1;
	private String event_title = DEFAULT_TITLE;
	
	private String param_event_title;
	private int param_version;
	private int param_part_id;
	private String param_bib;
	private String param_name;
	private String param_start;
	private String param_end;
	private String param_elapsed;
	
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
		
		if (req.getParameter("version") != null) {
			try {
				param_version = Integer.parseInt(req.getParameter("version"));
			} catch(NumberFormatException e) {
				param_version = -1;
			}
		} else {
			param_version = -1;
		}
		
		if (req.getParameter("part_id") != null) {
			System.out.println("part_id is not null...");
			try {
				param_part_id = Integer.parseInt(req.getParameter("part_id"));
				System.out.println("part_id parsed...");
				System.out.println("part_id is " + param_part_id);
			} catch(NumberFormatException e) {
				param_part_id = -1;
			}
		} else {
			param_part_id = -1;
		}

		param_event_title = req.getParameter("event_title");
		param_bib = req.getParameter("bib");
		param_name = req.getParameter("name");
		param_start = req.getParameter("start");
		param_end = req.getParameter("end");
		param_elapsed = req.getParameter("elapsed");
		
		if (param_event_title != null) {
			event_title = param_event_title;
		}
		
		if (req.getParameter("version") != null && req.getParameter("part_id") != null) {
			resp.getWriter().println("Error: GET request both asked for information (version parameter) and sent information (part_id parameter)");
			return;
		}
		
		if (req.getParameter("version") != null) {
			if (param_version < 0) {
				participants.clear();
				event_title = DEFAULT_TITLE;
				version=0;
				return;
			}
			
			if (param_version!=version) {
				resp.getWriter().println("<div class=\"hidden\" id=\"version\">"+version+"</div>");
				resp.getWriter().println("<h1>"+event_title+"</h1>");
				resp.getWriter().println(tableStart);
				for (ParticipantWebDisplay pojo : participants) {
					
					resp.getWriter().println("	<tr>"
							+ "		<td>"+pojo.getBib()+"</td>"
							+ "		<td>"+pojo.getName()+"</td>"
							+ "		<td>"+pojo.getStart()+"</td>"
							+ "		<td>"+pojo.getEnd()+"</td>"
							+ "		<td>"+pojo.getElapsed()+"</td>"
							+ "	</tr>");
				}
				resp.getWriter().println(tableEnd);
			}
		}
		if (req.getParameter("part_id") != null) {
			ParticipantWebDisplay participant = participantWithID(param_part_id);
			if (participant==null) {
				participant = new ParticipantWebDisplay(param_part_id);
				participants.add(participant);
			}
			if (param_bib!=null) participant.setBib(param_bib);
			if (param_name!=null) participant.setName(param_name);
			if (param_start!=null) participant.setStart(param_start);
			if (param_end!=null) participant.setEnd(param_end);
			if (param_elapsed!=null) participant.setElapsed(param_elapsed);
			version++;
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req,resp);
	}
	
	private ParticipantWebDisplay participantWithID(int id) {
		ParticipantWebDisplay result = null;
		for (ParticipantWebDisplay participant : participants) {
			if (participant.getPart_Id()==id) 
				return participant;
		}
		System.out.println("No participant found with part_id " + id);
		return result;
	}
}