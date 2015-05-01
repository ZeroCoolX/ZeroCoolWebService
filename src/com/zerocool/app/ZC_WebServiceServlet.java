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
		resp.getWriter().println("<!DOCTYPE html>"+
				"<html lang='en'>"+
				  "<head>"+
				    "<meta charset='utf-8'>"+
				    "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"+
				    "<meta name='viewport' content='width=device-width, initial-scale=1'>"+
				    "<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->"+
				    "<meta name='description' content=''>"+
				    "<meta name='author' content=''>"+
				    "<!-- <link rel='icon' href='../../favicon.ico'> -->"+
				    "<title>Chrono Timer Data</title>"+
				    "<!-- Bootstrap core CSS -->"+
				    "<link href='bootstrap.css' rel='stylesheet'>"+
				    "<!-- Custom styles for this template -->"+
				    "<link href='cover.css' rel='stylesheet'>"+
				  "</head>"+
				  "<body>"+
				    "<div class='site-wrapper'>"+
				      "<div class='site-wrapper-inner'>"+
				            "<!--Navigation bar at the top right and homepage link top left -->"+
				        "<div class='navbar navbar-aqua navbar-static-top' style='color:#083344'>"+
				          "<div class='container'>"+
				            "<a href='index.html' class='navbar-brand navbar-left'>Home</a>"+
				          "</div>"+
				        "</div>"+
				        "<div class='cover-container'>"+
				          "<div class='inner cover'>"+
				            "<h1 class='cover-heading'>Chrono Timer Data</h1>"+
				            "<p class='lead'>"+
				              "<!-- table with data -->");

							makeTable(req, resp);

				      		resp.getWriter().println("</p>"+
				          "</div>"+
				        "</div>"+
				      "</div>"+
				    "</div>"+
				    "<!--Contact information  #181818 -->"+
				  "<div class='footer ' style='background-color:Black'>"+
				    "<div class='container'>"+
				      "<div class='row'>"+
				    "<p class='text-right' style='color:White'>Chrono Timer&copy; 2015.</p>"+
				      "</div>"+
				    "</div>"+
				  "</div>"+
				    "<!-- Bootstrap core JavaScript"+
				    "================================================== -->"+
				    "<!-- Placed at the end of the document so the pages load faster -->"+
				    "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script>"+
				    "<script src='bootstrap.js'></script>"+
				  "</body>"+
				"</html>");
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