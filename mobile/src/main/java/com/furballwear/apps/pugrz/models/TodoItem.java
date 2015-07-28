package com.furballwear.apps.pugrz.models;

public class TodoItem {

	private String tiTtle;
	private String comPlete;
	private String id;
	private String ptimeStamp;
	private String gameType;
	private String gameStyle;
	private String shortDes;
	private String gloCation;
	
	public TodoItem (String tittle, String id, String complete, String ptimestamp, String gametype, String gamestyle,String shortdes,String glocation){
		this.tiTtle = tittle;
		this.id = id;
		this.comPlete = complete;
		this.ptimeStamp = ptimestamp;
		this.gameType = gametype;
		this.gameStyle = gamestyle;
		this.shortDes = shortdes;
		this.gloCation = glocation;
	}
	public String isComplete() {
		return comPlete;
	}

	public String getTittle() {
		return tiTtle;
	}
	public String getGametype() {
		return gameType;
	}
	public String getGamestyle() {
		return gameStyle;
	}
	public String getShortdes() {
		return shortDes;
	}
	public String getGlocation() {
		return gloCation;
	}
	public String getId() {
		return id;
	}
	public String getPtimestamp() {
		return ptimeStamp;
	}

	public void setTittle(String title) {
		this.tiTtle = title;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPtimestamp(String ptimestamp) {
		this.ptimeStamp = ptimestamp;
	}
	public void setShortdes(String shortdes) {
		this.shortDes = shortdes;
	}
	public void setGametype(String gametype) {
		this.gameType = gametype;
	}
	public void setGlocation(String glocation) {
		this.gloCation = glocation;
	}
	public void setGamestyle(String gamestyle) {
		this.gameStyle = gamestyle;
	}
	public void setComplete(String complete) {
		this.comPlete = complete;
	}
}
