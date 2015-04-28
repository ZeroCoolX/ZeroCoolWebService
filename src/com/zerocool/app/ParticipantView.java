package com.zerocool.app;

import java.util.Comparator;

public class ParticipantView {

	private String eventName;
	private String startTime;
	private String finishTime;
	private String elapsed;
	private long fin;
	private int bib;
	
	public String toRow() {
		return "<tr><td>" + bib + "</td><td>" + eventName + "</td><td>" + startTime + "</td><td>" + finishTime + "</td><td>" + elapsed + "</td></tr>";
	}
	
	public long getElapsedTime() {
		return fin;
	}
	
	public static class Com implements Comparator<ParticipantView> {

		@Override
		public int compare(ParticipantView p1, ParticipantView p2) {
			return (int) (p1.getElapsedTime() - p2.getElapsedTime());
		}
		
	}
	
}
