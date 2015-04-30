package com.zerocool.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.*;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.zerocool.app.tables.TableList;

@SuppressWarnings("serial")
public class ZC_WebServiceServlet extends HttpServlet {
	
	private TableList tables = new TableList();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<link rel='stylesheet' type='text/css' href='webserv.css'>");
		makeTable(req, resp);
	}
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		tables.addParticipants((ArrayList<ParticipantView>) new Gson().fromJson(req.getParameter("data"), new TypeToken<ArrayList<ParticipantView>>(){}.getType()));
	}
	
	private void makeTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println(tables.getTables());
	}
}