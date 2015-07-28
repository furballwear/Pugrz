package com.furballwear.apps.pugrz.json;

import com.furballwear.apps.pugrz.models.Game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.furballwear.apps.pugrz.extras.Constants;


import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_AUDIENCE_SCORE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_CAST;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_COMPLETE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_ID;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_LINKS;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_MOVIES;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_POSTERS;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_RATINGS;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_RECORD;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_RELEASE_DATES;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_REVIEWS;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_SELF;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_SIMILAR;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_SYNOPSIS;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_THEATER;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_THUMBNAIL;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_TITLE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMEID;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMENAME;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_SHORTDES;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMEDATE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMETIME;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMETYPE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMESTYLE;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GLOCATION;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_GAMECITY;
import static com.furballwear.apps.pugrz.extras.Keys.EndpointBoxOffice.KEY_USER_ID_CREATE;

/**
 * Created by Windows on 02-03-2015.
 */
public class Parser {
    public static ArrayList<Game> parseGamesJSON(JSONObject response) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Game> listGames = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                JSONArray arrayGames = response.getJSONArray(KEY_RECORD);
                for (int i = 0; i < arrayGames.length(); i++) {

                    String complete = Constants.NA;
                    String gamedate = Constants.NA;
                    String id = Constants.NA;
                    String shortdes = Constants.NA;
                    String gametitle = Constants.NA;
                    String gametime = Constants.NA;
                    String gametype = Constants.NA;
                    String gamestyle = Constants.NA;
                    String glocation = Constants.NA;
                    String user_id_create = Constants.NA;
                    String gamecity = Constants.NA;
                    JSONObject currentGame = arrayGames.getJSONObject(i);
                    //get the id of the current movie
                    if (Utils.contains(currentGame, KEY_GAMEID)) {
                        id = currentGame.getString(KEY_GAMEID);
                    }
                    //get the title of the current movie
                    if (Utils.contains(currentGame, KEY_GAMENAME)) {
                        gametitle = currentGame.getString(KEY_GAMENAME);
                    }

                    //get the date in theaters for the current movie
                    if (Utils.contains(currentGame, KEY_SHORTDES)) {
                       shortdes = currentGame.getString(KEY_SHORTDES);
                    }
                    if (Utils.contains(currentGame, KEY_GAMEDATE)) {
                        gamedate = currentGame.getString(KEY_GAMEDATE);
                    }
                    if (Utils.contains(currentGame, KEY_GAMETIME)) {
                        gametime = currentGame.getString(KEY_GAMETIME);
                    }
                    if (Utils.contains(currentGame, KEY_GAMESTYLE)) {
                        gamestyle = currentGame.getString(KEY_GAMESTYLE);
                    }

                    if (Utils.contains(currentGame, KEY_GAMETYPE)) {
                        gametype = currentGame.getString(KEY_GAMETYPE);
                    }

                    if (Utils.contains(currentGame, KEY_GLOCATION)) {
                        glocation = currentGame.getString(KEY_GLOCATION);
                    }
                    if (Utils.contains(currentGame, KEY_COMPLETE)) {
                        complete = currentGame.getString(KEY_COMPLETE);
                    }
                    if (Utils.contains(currentGame, KEY_GAMECITY)) {
                        gamecity = currentGame.getString(KEY_GAMECITY);
                    }
                    if (Utils.contains(currentGame, KEY_USER_ID_CREATE)) {
                        user_id_create = currentGame.getString(KEY_USER_ID_CREATE);
                    }


                    Game game = new Game();
                    game.setId(id);
                    game.setTittle(gametitle);
                    game.setShortdes(shortdes);
                    game.setGamedate(gamedate);
                    game.setGametime(gametime);
                    game.setGametype(gametype);
                    game.setGamestyle(gamestyle);
                    game.setGlocation(glocation);
                    game.setComplete(complete);
                    game.setGamecity(gamecity);
                    game.setUser_id_create(user_id_create);
                        listGames.add(game);
                    }


            } catch (JSONException e) {

            }
//                L.t(getActivity(), listMovies.size() + " rows fetched");
        }
        return listGames;
    }


}
