package com.zerocool.app;

public class ParticipantWebDisplay {

	private int part_id;
	
	private String bib;
	private String name;
	private String start;
	private String end;
	private String elapsed;
	
	public ParticipantWebDisplay() {
	}
	public ParticipantWebDisplay(int part_id) {
		setPart_Id(part_id);
	}
	public ParticipantWebDisplay(int part_id, String bib, String Name, String start, String end, String elapsed){
		setPart_Id(part_id);
		setBib(bib);
		setName(Name);
		setStart(start);
		setEnd(end);
		setElapsed(elapsed);
	}
	
	// null input sets field to blank string
	
	public int getPart_Id(){
		return part_id;
	}
	public void setPart_Id(int part_id){
		this.part_id = part_id;
	}
	public String getBib() {
		return bib==null?"":bib;
	}
	public void setBib(String bib) {
		this.bib = bib==null?"":bib;
	}
	public String getName() {
		return name==null?"":name;
	}
	public void setName(String name) {
		this.name = name==null?"":name;
	}
	public String getStart() {
		return start==null?"":start;
	}
	public void setStart(String start) {
		this.start = start==null?"":start;
	}
	public String getEnd() {
		return end==null?"":end;
	}
	public void setEnd(String end) {
		this.end = end==null?"":end;
	}
	public String getElapsed() {
		return elapsed==null?"":elapsed;
	}
	public void setElapsed(String elapsed) {
		this.elapsed = elapsed==null?"":elapsed;
	}

}
