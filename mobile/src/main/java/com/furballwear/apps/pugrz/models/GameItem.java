package com.furballwear.apps.pugrz.models;

/**
 * Created by furballadmin on 6/6/2015.
 */
public class GameItem {

    private String tiTtle;
    private boolean complete;
    private String id;
    private String ptimeStamp;
    private String gameType;
    private String gameStyle;
    private String gameDate;
    private String gameTime;
    private String shortDes;
    private String gloCation;
    private String gameCity;
    private String user_Id_create;

    public GameItem (String tittle, String id, boolean complete, String ptimestamp, String gametype, String gamestyle,String shortdes,String glocation,String gamedate, String gametime, String gamecity, String user_id_create){
        this.tiTtle = tittle;
        this.id = id;
        this.complete = complete;
        this.ptimeStamp = ptimestamp;
        this.gameType = gametype;
        this.gameStyle = gamestyle;
        this.gameDate = gamedate;
        this.gameTime = gametime;
        this.shortDes = shortdes;
        this.gloCation = glocation;
        this.gameCity = gamecity;
        this.user_Id_create = user_id_create;
    }
    public boolean isComplete() {
        return complete;
    }

    public String getTitle() {
        return tiTtle;
    }
    public String getGamedate() {
        return gameDate;
    }
    public String getGametime() {
        return gameTime;
    }
    public String getGametype() {
        return gameType;
    }
    public String getGamestyle() {
        return gameStyle;
    }
    public String getGamecity() {
        return gameCity;
    }
    public String getUser_id_create() {
        return user_Id_create;
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
    public String getPtimeStamp() {
        return ptimeStamp;
    }

    public void setTittle(String tiTtle) {
        this.tiTtle = tiTtle;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPtimestamp(String ptimeStamp) {
        this.ptimeStamp = ptimeStamp;
    }
    public void setShortdes(String shortDes) {
        this.shortDes = shortDes;
    }
    public void setGamecity(String gamecity) {
        this.gameCity = gamecity;
    }
    public void setGametype(String gametype) {
        this.gameType = gametype;
    }
    public void setGametime(String gametime) {
        this.gameTime = gametime;
    }
    public void setGamedate(String gamedate) {
        this.gameDate = gamedate;
    }
    public void setGlocation(String glocation) {
        this.gloCation = glocation;
    }
    public void setGamestyle(String gamestyle) {
        this.gameStyle = gamestyle;
    }
    public void setUser_id_create(String user_id_create) {
        this.user_Id_create = user_id_create;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        sb.append("class GameItem {\n");
        sb.append("  id: ").append(id).append("\n");
        sb.append("  title: ").append(tiTtle).append("\n");
        sb.append("  complete: ").append(complete).append("\n");
        sb.append("  gametype: ").append(gameType).append("\n");
        sb.append("  gamestyle: ").append(gameStyle).append("\n");
        sb.append("  shortdes: ").append(shortDes).append("\n");
        sb.append("  gamedate: ").append(gameDate).append("\n");
        sb.append("  gametime: ").append(gameTime).append("\n");
        sb.append("  gamecity: ").append(gameCity).append("\n");
        sb.append("  user_id_create: ").append(user_Id_create).append("\n");
        sb.append("  glocation: ").append(gloCation).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

}

