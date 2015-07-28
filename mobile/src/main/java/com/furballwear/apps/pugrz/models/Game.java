package com.furballwear.apps.pugrz.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;



/**
 * Created by Windows on 09-02-2015.
 */
public class Game implements Parcelable {
    public static final Creator<Game> CREATOR
            = new Creator<Game>() {
        public Game createFromParcel(Parcel in) {
         //   L.m("create from parcel :Game");
            return new Game(in);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
    private String id;
    private String tittle;
    private String gamedate;
    private String gametime;
    private String shortdes;
    private String gamecity;
    private String gametype;
    private String user_id_create;
    private String gamestyle;
    private String complete;
    private String glocation;


public Game(){}

    public Game(Parcel input) {
        id = input.readString();
        tittle = input.readString();
        gamedate = input.readString();
        gametime = input.readString();
        gametype = input.readString();
        gamestyle = input.readString();
        user_id_create = input.readString();
        gamecity = input.readString();
        complete = input.readString();

    }
        public Game (


         String id,
         String tittle,
         String complete,
        String gametype,
        String gamestyle,
         String shortdes,
        String glocation,
        String gamedate,
         String gamecity,
         String user_id_create,
        String gametime){
        this.tittle = tittle;
        this.id = id;
        this.complete = complete;
        this.gamedate = gamedate;
        this.gametime = gametime;
        this.gametype = gametype;
        this.gamestyle = gamestyle;
        this.shortdes = shortdes;
        this.glocation = glocation;
            this.gamecity = gamecity;
            this.user_id_create = user_id_create;
    }



        public String getTittle() {
            return tittle;
        }
        public String getGametype() {
            return gametype;
        }
        public String getGamestyle() {
            return gamestyle;
        }
        public String getShortdes() {
            return shortdes;
        }
        public String getGlocation() {
            return glocation;
        }
        public String getId() {
            return id;
        }
    public String getUser_id_create() {
        return user_id_create;
    }
    public String getGamecity() {
        return gamecity;
    }
    public String getGamedate() {
        return gamedate;
    }
    public String getGametime() {
        return gametime;
    }
    public String getComplete() {
        return complete;
    }

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }
        public void setId(String id) {
            this.id = id;
        }
        public void setGamedate(String gamedate) {
        this.gamedate = gamedate;
    }
        public void setGametime(String gametime) {
        this.gametime = gametime;
    }
        public void setShortdes(String shortdes) {
            this.shortdes = shortdes;
        }
        public void setGametype(String gametype) {
            this.gametype = gametype;
        }
        public void setGlocation(String glocation) {
            this.glocation = glocation;
        }
        public void setGamestyle(String gamestyle) {
            this.gamestyle = gamestyle;
        }
    public void setUser_id_create(String user_id_create) {
        this.user_id_create = user_id_create;
    }
    public void setGamecity(String gamecity) {
        this.gamecity = gamecity;
    }
        public void setComplete(String complete) {
            this.complete = complete;
        }


        @Override
        public String toString() {
            return "\nID: " + id +
                    "\nTittle " + tittle +
                    "\nGamedate " + gamedate +
                    "\nGametime " + gametime +
                    "\nGametype " + gametype +
                    "\nGamestyle " + gamestyle +
                    "\nShortdes " + shortdes +
                    "\nGlocation " + glocation +
                    "\nComplete " + complete +
                    "\nUser_id_create " + user_id_create +
                    "\nGamecity " + gamecity +

                    "\n";
        }








    @Override
    public int describeContents() {
   //     L.m("describe Contents Game");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
 //       L.m("writeToParcel Game");
        dest.writeString(id);
        dest.writeString(tittle);
        dest.writeString(gamedate);
        dest.writeString(gametime);
        dest.writeString(shortdes);
        dest.writeString(gamestyle);
        dest.writeString(gametype);
        dest.writeString(glocation);
        dest.writeString(gamecity);
        dest.writeString(user_id_create);




    }
}
