package com.zerocool.app.tables;

import java.util.ArrayList;

import com.zerocool.app.ParticipantView;

public class EventTable {

	ArrayList<RunTable> runTableList;
	
	private String eventName;
	
	private int numOfRuns;
	
	public EventTable(String eventName) {
		runTableList = new ArrayList<RunTable>();
		this.eventName = eventName;
		numOfRuns = 0;
	}
	
	public EventTable addRun(ArrayList<ParticipantView> participants) {
		runTableList.add(new RunTable(participants, ++numOfRuns));
		return this;
	}
	
	public String getTable() {
		String table = "<h2>" + eventName + "</h2>";
		
		for (RunTable rt : runTableList) {
			table += rt.getTable();
		}
		
		return table;
	}
	
	public String getName() {
		return eventName;
	}
	
}
