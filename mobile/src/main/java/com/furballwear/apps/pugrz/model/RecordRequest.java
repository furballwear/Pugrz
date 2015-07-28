package com.furballwear.apps.pugrz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class RecordRequest {
	/* Array of field name-value pairs. */
	@JsonProperty("_field_")
	private List<String> _field_ = new ArrayList<String>();
	@JsonProperty("gamecity")
	private String gamecity;
	@JsonProperty("tittle")
	private String tittle;
	@JsonProperty("name")
	private String name;
	@JsonProperty("gametype")
	private String gametype;
	@JsonProperty("shortdes")
	private String shortdes;
	@JsonProperty("gamestyle")
	private String gamestyle;
	@JsonProperty("id")
	private String id;
	@JsonProperty("glocation")
	private String glocation;
	@JsonProperty("complete")
	private boolean complete;
	@JsonProperty("gamedate")
	private String gamedate;
	@JsonProperty("gametime")
	private String gametime;
	public String getGamecity(){
		return gamecity;
	}
	public void setGamecity(String gamecity){
		this.gamecity = gamecity;
	}
	public List<String> get_field_() {
		return _field_;
	}
	public void set_field_(List<String> _field_) {
		this._field_ = _field_;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setTittle(String tittle){
		this.tittle = tittle;
	}
	public void setGlocation(String glocation){
		this.glocation = glocation;
	}
	public void setComplete(boolean complete){
		this.complete = complete;
	}
	public void setGametype(String gametype){
		this.gametype = gametype;
	}
	public void setGamestyle(String gamestyle){
		this.gamestyle = gamestyle;
	}
	public String getTittle(){
		return tittle;
	}
	public String getId(){
		return id;
	}
	public boolean isComplete(){
		return complete;
	}
	public void setShortdes(String shortdes){
		this.shortdes = shortdes;
	}
	public String getGametype(){
		return gametype;
	}
	public String getGamestyle(){
		return gamestyle;
	}
	public String getGlocation(){
		return glocation;
	}
	public String getShortdes(){
		return shortdes;
	}
	public String getGamedate(){
		return gamedate;}
	public void setGamedate(String gamedate){
		this.gamedate = gamedate;
	}
	public String getGametime(){
		return gametime;}
	public void setGametime(String gametime){
		this.gametime = gametime;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	@Override
	public String toString()  {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordRequest {\n");
		sb.append("  _field_: ").append(_field_).append("\n");
		sb.append("  tittle: ").append(tittle).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  complete: ").append(complete).append("\n");
		sb.append("  gametype: ").append(gametype).append("\n");
		sb.append("  gamestyle: ").append(gamestyle).append("\n");
		sb.append("  shortdes: ").append(shortdes).append("\n");
		sb.append("  glocation: ").append(glocation).append("\n");
		sb.append("  gamedate: ").append(gamedate).append("\n");
		sb.append("  gametime: ").append(gametime).append("\n");
		sb.append("  gamecity: ").append(gamecity).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
