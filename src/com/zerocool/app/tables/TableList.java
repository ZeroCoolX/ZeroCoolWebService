package com.zerocool.app.tables;

import java.util.ArrayList;

import com.zerocool.app.ParticipantView;

public class TableList {

	ArrayList<EventTable> eventTableList;

	public TableList() {
		eventTableList = new ArrayList<EventTable>();
	}

	public void addParticipants(ArrayList<ParticipantView> participants) {
		if (!participants.isEmpty()) {
			String eventName = participants.get(0).getEventName();
			EventTable et = containsEvent(eventName);
			if (et == null) {
				et = new EventTable(eventName).addRun(participants);
				eventTableList.add(et);
			} else {
				et.addRun(participants);
			}
		}
	}

	public String getTables() {
		String tables = "";

		for (EventTable et : eventTableList) {
			tables += et.getTable();
		}

		return tables;
	}
	
	public void reset() {
		eventTableList.clear();
	}

	private EventTable containsEvent(String eventName) {
		for (EventTable et : eventTableList) {
			if (et.getName().equals(eventName)) {
				return et;
			}
		}

		return null;
	}

}
