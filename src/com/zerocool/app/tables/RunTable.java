package com.zerocool.app.tables;

import java.util.ArrayList;
import java.util.Collections;

import com.zerocool.app.ParticipantView;

public class RunTable {
	
	private String table;
	private String tableStart = "<table class='table table-striped' style='background-color:DarkGrey'>"
			+ "	<tr>"
			+ " 	<th>Bib Number</th>"
			+ "		<th>Event Name</th>"
			+ "		<th>Start Time</th>"
			+ "		<th>Finish Time</th>"
			+ "		<th>Elapsed Time</th>"
			+ "	</tr>";
	private String tableEnd = "</table>";
	
	public RunTable(ArrayList<ParticipantView> participants, int runNum) {
		table = "<h4>Run " + runNum + "</h4>";
		table += tableStart;
		
		Collections.sort(participants, new ParticipantView.Com());
		
		for (ParticipantView p : participants) {
			table += p.toRow();
		}
		
		table += tableEnd;
	}
	
	public String getTable() {
		return table;
	}
	
}
