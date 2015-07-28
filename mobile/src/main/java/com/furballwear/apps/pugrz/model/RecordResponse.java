package com.furballwear.apps.pugrz.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordResponse {
	/* Array of field name-value pairs. */
	  @JsonProperty("_field_")
	  private List<String> _field_ = new ArrayList<String>();
	@JsonProperty("gamecity")
	private String gamecity;
	  @JsonProperty("tittle")
	  private String tittle;
	@JsonProperty("name")
	private String name;
	  @JsonProperty("id")
	  private String id;

	@JsonProperty("gametype")
	private String gametype;

	  @JsonProperty("complete")
	  private boolean complete;

	@JsonProperty("ptimestamp")
	private String ptimestamp;

	@JsonProperty("gamestyle")
	private String gamestyle;
	@JsonProperty("shortdes")
	private String shortdes;
	@JsonProperty("glocation")
	private String glocation;
	@JsonProperty("gamedate")
	private String gamedate;
	@JsonProperty("gametime")
	private String gametime;


	  public List<String> get_field_() {
	    return _field_;
	  }
	  public void set_field_(List<String> _field_) {
	    this._field_ = _field_;
	  }
	  
	  public void setId(String id){
		  this.id = id;
	  }
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public String getGamecity(){
		return gamecity;
	}
	public void setGamecity(String gamecity){
		this.gamecity = gamecity;
	}
	public void setTittle(String tittle){
		  this.tittle = tittle;
	  }
	public void setGamestyle(String gamestyle){
		this.gamestyle = gamestyle;
	}
	public void setPTimestamp(String ptimestamp){
		this.ptimestamp = ptimestamp;
	}
	  public void setComplete(boolean complete){
		  this.complete = complete;
	  }
	public void setGametype(String gametype){
		this.gametype = gametype;
	}
	public void setGlocation(String glocation){
		this.glocation = glocation;
	}
	public void setShortdes(String shortdes){
		this.shortdes = shortdes;
	}

	  public String getTittle(){
		  return tittle;
	  }
	public String getPTimestamp(){
		return ptimestamp;
	}
	public String getGamestyle(){
		return gamestyle;
	}
	public String getGametype(){
		return gametype;
	}
	public String getGlocation(){
		return glocation;
	}
	public String getShortdes(){
		return shortdes;
	}
	  public String getId(){
		  return id;
	  }
	  
	  public boolean iscomplete(){
		  return complete;
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

	  @Override
	  public String toString()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class RecordResponse {\n");
	    sb.append("  _field_: ").append(_field_).append("\n");
	    sb.append("  tittle: ").append(tittle).append("\n");
	    sb.append("  id: ").append(id).append("\n");
	    sb.append("  complete: ").append(complete).append("\n");
		  sb.append("  ptimestamp: ").append(ptimestamp).append("\n");
		  sb.append("  gametype: ").append(gametype).append("\n");
		  sb.append("  gamestyle: ").append(gamestyle).append("\n");
		  sb.append("  glocation: ").append(glocation).append("\n");
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

